package kr.codesquad.model;

import kr.codesquad.view.OutputView;

public class Validator {

    private final OutputView outputView;

    public Validator(OutputView outputView) {
        this.outputView = outputView;
    }

    public boolean checkUserInputPlayersNameLength(String playersName) {
        boolean whetherValidateName = true;
        String[] participants = turnStringIntoStringArray(playersName);
        whetherValidateName = isWhetherValidateName(whetherValidateName, participants);
        if (!whetherValidateName) {
            throw new IllegalArgumentException();
        }
        return whetherValidateName;
    }

    private boolean isWhetherValidateName(boolean whetherValidateName, String[] participants) {
        for (int i = 0; i < participants.length && whetherValidateName; i++) {
            whetherValidateName = checkWhetherPlayersNameLengthValidate(participants[i]);
        }
        return whetherValidateName;
    }

    private boolean checkWhetherPlayersNameLengthValidate(String name) {
        if (name.length() < 6 && name.length() > 0) {
            return true;
        }
        return false;
    }

    private String[] turnStringIntoStringArray(String playersName) {
        String[] participants = playersName.split(",");
        for (int i = 0; i < participants.length; i++) {
            participants[i] = participants[i].trim();
        }
        return participants;
    }
}
