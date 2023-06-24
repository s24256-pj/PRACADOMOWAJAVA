package currencynbp.currency;

public class Rate{
    public String no;
    public String effectiveDate;
    public double mid;

    public String getNo() {
        return no;
    }

    public double getMid() {
        return mid;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
