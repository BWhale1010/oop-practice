package org.example;

public class User {
    private String password;

    public void intitPassword(PasswordGenerator passwordGenerator){
        // as-is (강한 결합도)
        // RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be
        // 상위의 인터페이스 패스워드 제너레이터를 두어서 결합도를 낮춤

        // 내부에서 랜덤패스워드 제너레이터를 가지고 있으면 조건에 부합하지 않으면 테스트 실패하게 된다.
        // 이를 해결하기 위해 상위의 패스워드제너레이터라는 인터페이스를 선언하고 테스트 컨트롤를 위해 성공 / 실패가 되는 패스워드제너레이터를 통해
        // 항상 통과 / 실패하는 경우를 만듦

        String password = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */

        if (password.length()>=8 && password.length() <= 12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
