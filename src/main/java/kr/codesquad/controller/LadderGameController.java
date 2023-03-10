package kr.codesquad.controller;

import kr.codesquad.model.Converter;
import kr.codesquad.model.Ladder;
import kr.codesquad.model.LadderMaker;
import kr.codesquad.model.Validator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;
    private final Converter converter;
    private final Validator validator;

    public LadderGameController(InputView inputView, OutputView outputView, LadderMaker ladderMaker, Converter converter, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
        this.converter = converter;
        this.validator = validator;
    }

    public void ladderGameStart() {
        String playersName = promptValidPlayersName();
        outputView.printAskHeightOfLadder();
        int heightOfLadder = inputView.userInputHeightOfLadder();
        Ladder ladder = ladderMaker.createLadder(playersName, heightOfLadder);
        outputView.printLadder(converter.convertLadderToString(ladder));
    }

    private String promptValidPlayersName() {
        boolean checkWhetherPlayersNameValid = false;
        String userInputPlayersName = "";
        while (!checkWhetherPlayersNameValid) {
            try {
                outputView.printAskNameOfPlayers();
                userInputPlayersName = inputView.userInputPlayersName();
                checkWhetherPlayersNameValid = validator.checkUserInputPlayersNameLength(userInputPlayersName);
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printInvalidPlayersName();
            }
        }
        return userInputPlayersName;
    }
}
