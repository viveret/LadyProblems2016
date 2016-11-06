package com.ladyproblems16.app1;


public class ScriptGenerator {
    private IUserDescription myUserDescription;

    public ScriptGenerator(IUserDescription theUserDesc) {
        myUserDescription = theUserDesc;
    }

    public String generateDefault() {
		StringBuilder sb = new StringBuilder();
		sb.append("This is an emergency message from ");
		sb.append(myUserDescription.getFullName());
		sb.append(". I am a ");
		sb.append(myUserDescription.getAge());
		sb.append(" year old ");
		sb.append(myUserDescription.getGender());
		sb.append(" located at ");

        return sb.toString();
    }
}
