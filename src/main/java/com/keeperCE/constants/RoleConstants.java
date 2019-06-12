package com.keeperCE.constants;

    public enum RoleConstants{
        ADMIN(1),
        SUBSCRIBER(2);

        private int value;

        RoleConstants(int value){
            this.value=value;
        }
        RoleConstants(){
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


