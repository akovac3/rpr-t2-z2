package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double t1,t2;
    private boolean pripadaT1,pripadaT2;

    private double getT1(){
        return t1;
    }

    public boolean isPripadaT2() {
        return pripadaT2;
    }

    public boolean isPripadaT1() {
        return pripadaT1;
    }

    public double getT2() {
        return t2;
    }

    public void setT1(double t1) {
        this.t1 = t1;
    }

    public void setT2(double t2) {
        this.t2 = t2;
    }


    public void setPripadaT1(boolean pripadaT1) {
        this.pripadaT1 = pripadaT1;
    }

    public void setPripadaT2(boolean pripadaT2) {
        this.pripadaT2 = pripadaT2;
    }

    public Interval(double t1, double t2, boolean pripadaT1, boolean pripadaT2) throws IllegalArgumentException{
        if(t1>t2) throw new IllegalArgumentException("Početna tačka veća od krajnje");
            this.t1=t1;
            this.t2=t2;
            this.pripadaT1=pripadaT1;
            this.pripadaT2=pripadaT2;
    }

    public Interval(){
        t1=0; t2=0;
        pripadaT1=false;
        pripadaT2=false;
    }

    public boolean isNull(){
        if(t1==0 && t2==0)return true;
        return false;
    }

    public boolean isIn(double tacka){
        if(tacka==t1){
            if(isPripadaT1())return true;
            return false;
        }
        if(tacka==t2){
            if(isPripadaT2())return true;
            return false;
        }

        if(tacka>t1 && tacka<t2)return true;
        return false;
    }

    public Interval intersect(Interval i){
        Interval povratna=new Interval();
        if(i.getT1()>=this.getT1()){
            povratna.setT1(i.getT1());
            //if(i.isPripadaT1())
                povratna.setPripadaT1(i.isPripadaT1());
        }
        else {
            povratna.setT1(this.getT1());
            //if(this.isPripadaT1())
                povratna.setPripadaT1(this.isPripadaT1());
        }
        if(i.getT2()<=this.getT2()){
            povratna.setT2(i.getT2());
            povratna.setPripadaT2(i.isPripadaT2());
        }
        else{
            povratna.setT2(this.getT2());
            povratna.setPripadaT2(this.isPripadaT2());
        }
        return povratna;
    }

    public static Interval intersect(Interval i1, Interval i2){
        Interval povratna=new Interval();
        if(i1.getT1()>=i2.getT1()){
            povratna.setT1(i1.getT1());
            //if(i.isPripadaT1())
            povratna.setPripadaT1(i1.isPripadaT1());
        }
        else {
            povratna.setT1(i2.getT1());
            //if(this.isPripadaT1())
            povratna.setPripadaT1(i2.isPripadaT1());
        }
        if(i1.getT2()<=i2.getT2()){
            povratna.setT2(i1.getT2());
            povratna.setPripadaT2(i1.isPripadaT2());
        }
        else{
            povratna.setT2(i2.getT2());
            povratna.setPripadaT2(i2.isPripadaT2());
        }
        return povratna;
    }

    @Override
    public boolean equals(Object obj) {
        Interval i1=(Interval) obj;
        if(getT1()==i1.getT1() && getT2()==i1.getT2() && isPripadaT1()==i1.isPripadaT1() && isPripadaT2()==i1.isPripadaT2())return true;
        return false;
    }

    @Override
    public String toString() {
        String s="";
        if(isNull())return "()";
        if(!isPripadaT1())s+="(";
        else s+="[";
        s+=this.getT1();
        s+=",";
        s+=this.getT2();
        if(!isPripadaT2())s+=")";
        else s+="]";
        return s;
    }
}
