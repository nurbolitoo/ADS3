

public class MyTestingClass {
    private String key;

    public MyTestingClass(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        // Custom hash code calculation
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = 31 * hash + key.charAt(i);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null || getClass() != obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return key.equals(that.key);
    }
    public String getKey(){
        return key;
    }

    public void setKey(String key){
        this.key=key;
    }
}