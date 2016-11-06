package com.ladyproblems16.app1;


public class ScriptGenerator {
    private IUserDescription myUserDescription;
    private IGpsAccess myLocation;

    public ScriptGenerator(IUserDescription theUserDesc, IGpsAccess location) {
        myUserDescription = theUserDesc;
        myLocation = location;
    }

    public String generateDefault() {
		StringBuilder sb = new StringBuilder();
		sb.append("This is an emergency message from ");
		sb.append(myUserDescription.getFullName());
		sb.append(". I am a ");
		sb.append(myUserDescription.getEthnicityRace());
        sb.append(", ");
		sb.append(myUserDescription.getAge());
		sb.append(" year old ");
		sb.append(myUserDescription.getGender());
		sb.append(" located at ");
        sb.append(myLocation.getStreetAddress());
        sb.append(", ");
        sb.append(myLocation.getCity());
        sb.append(", GPS coordinates ");
        sb.append(myLocation.getLatitude() + " north, and ");
        sb.append(myLocation.getLongitude() + " west. ");
        sb.append("I am in danger and need help.");

        return sb.toString();
    }
}
