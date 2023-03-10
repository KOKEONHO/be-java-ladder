package kr.codesquad.model;

public class Validator {

    public boolean checkUserInputPlayersNameLength(String playersName) {
        
    }

    private String[] turnStringIntoStringArray(String playersName) {
        String[] participants = playersName.split(",");
        for (int i = 0; i < participants.length; i++) {
            participants[i] = participants[i].trim();
        }
        return participants;
    }
}
