package com.keeperCE.constants;

public enum RoleConstants{
        ADMIN(1),
        SUBSCRIBER(2),
        ROLE("ROLE_");

        private int value;
        private String stringValues;

        RoleConstants(int value){
            this.value=value;
        }
        RoleConstants(){
        }

    public String getStringValues() {
        return stringValues;
    }

    public void setStringValues(String stringValues) {
        this.stringValues = stringValues;
    }

    RoleConstants(String role){
            this.stringValues=role;
        }
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


