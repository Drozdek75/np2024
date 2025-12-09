package np.np2024.np2024.models.order.pojo;

public class orderDetailFF {

    private int id;
    private int type;
    private long cod_product;

    public orderDetailFF() {
    }


    public orderDetailFF(int id, int type, long cod_product) {
        this.id = id;
        this.type = type;
        this.cod_product = cod_product;
    }



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getCod_product() {
        return this.cod_product;
    }

    public void setCod_product(long cod_product) {
        this.cod_product = cod_product;
    }


}
