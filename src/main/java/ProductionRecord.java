import java.util.Date;

public class ProductionRecord {
    Product pr;
    int productionNum;
    int productID;
    String serialNum;
    Date prodDate;

    public ProductionRecord(int productID) {
        this.productID = productID;
        productionNum = 0;
        serialNum = "0";
        prodDate = new Date();
    }

    public ProductionRecord(Product pr, int productionNum) {
        this.pr = pr;
        this.productionNum = productionNum;
        this.prodDate = new Date();
        serialNum(productionNum);
    }

    public ProductionRecord(int productionNum, int productID, String serialNumber, Date prodDate) {
        this.productionNum = productionNum;
        this.productID = productID;
        this.serialNum = serialNumber;
        this.prodDate = prodDate;
    }

    public void serialNum(int newSerialNum) {
        setSerialNum(pr.getManufacturer().substring(0, 3) + pr.getType().code + String.format("%05d", newSerialNum));
    }

    @Override
    public String toString() {
        return "Prod. Num: " + productionNum + " Product ID: " + productID + " Serial Num: " + serialNum +
                " Date: " + prodDate;
    }

    public int getProductionNum(){
        return productionNum;
    }
    public void setProductionNum(int productionNum) {
        this.productionNum = productionNum;
    }

    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }

    public String getSerialNum() { return serialNum; }
    public void setSerialNum(String serialNum) { this.serialNum = serialNum; }

    public Date getProdDate() { return prodDate; }
    public void setProdDate(Date prodDate) { this.prodDate = prodDate; }


}
