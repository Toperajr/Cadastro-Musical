public class show {
    private int id;
    private String cache;
    private String data;
    private cantor cantor;
    private local local;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCache() {
        return this.cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public cantor getCantor() {
        return this.cantor;
    }

    public void setCantor(cantor cantor) {
        this.cantor = cantor;
    }

    public local getLocal() {
        return this.local;
    }

    public void setLocal(local local) {
        this.local = local;
    }
    public String getCantorNome(){
        return this.cantor.getNome();
    }
    public String getLocalEstabelecimento(){
        return this.local.getEstabelecimento();
    }

}
