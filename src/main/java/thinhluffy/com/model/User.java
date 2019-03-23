package thinhluffy.com.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class User implements Validator {
    private String lastName;
    private String firstName;
    private String number;
    private String email;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        String lastName = user.getLastName();
        String firstName = user.getFirstName();
        String number = user.getNumber();
        String email = user.getEmail();
        int age = user.getAge();
        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
        ValidationUtils.rejectIfEmpty(errors,"lastName","lastName.empty");
        ValidationUtils.rejectIfEmpty(errors,"firstName","firstName.empty");
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
        ValidationUtils.rejectIfEmpty(errors,"age","age.empty");
        if (lastName.length()>45||firstName.length()<5){
            errors.rejectValue("lastName","lastName.length");
        }
        if (lastName.length()>45||firstName.length()<5){
            errors.rejectValue("firstName","firstName.length");
        }
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("number","number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number","number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }
        if (age<18){
            errors.rejectValue("age","age.length");
        }
        if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            errors.rejectValue("email","email.matches");
        }
    }
}
