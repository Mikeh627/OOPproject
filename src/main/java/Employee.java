public class Employee {
    StringBuilder name;
    String username;
    String password;
    String email;

    public Employee (String name, String password) {

        this.password = password;

        if (checkName(name) == true) {
            setUsername(name);
            setEmail(name);
        } else {
            username = "default";
            email = "user@oracleacademy.Test";
        }

        if (isValidPassword(password) == true) {
            this.password = password;
        } else {
            this.password = "pw";
        }
    }

    public String toString() {
        return "Employee Details" + "\n" + "Name : " + name + "\n" + "Username : " + username + "\n" + "Email : "
                + email + "\n" + "Initial Password : " + password;
    }

    private void setUsername(String name) {
        String[] nameArray = name.split(" ");

        username = (nameArray[0].charAt(0) + nameArray[1]).toLowerCase();
    }

    private boolean checkName(String name) {
        this.name = new StringBuilder(name);
        return name.contains(" ");
    }

    private void setEmail(String name) {
        String[] nameArray = name.split(" ");

        email = (nameArray[0] + "." + nameArray[1]).toLowerCase()
                + "@oracleacademy.Test";
    }

    private boolean isValidPassword(String password) {
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasSpecial   = !password.matches("[A-Za-z0-9 ]*");

        if (hasUppercase & hasLowercase & hasSpecial) {
            return true;
        }
        else{
            return false;
        }
    }
}
