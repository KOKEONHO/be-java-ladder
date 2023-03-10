package kr.codesquad;

import kr.codesquad.controller.LadderGameController;
import kr.codesquad.model.Converter;
import kr.codesquad.model.LadderMaker;
import kr.codesquad.model.Validator;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        LadderGameController ladderGameController = new LadderGameController(new InputView(), outputView, new LadderMaker(), new Converter(), new Validator(outputView));
        ladderGameController.ladderGameStart();
    }
}
