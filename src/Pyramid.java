class Pyramid {
    private String pharaoh;
    private String ancient_name;
    private String modern_name;
    private Integer dynasty;
    private String site;
    private Double base1;
    private Double base2;
    private Double height;
    private Double slope;
    private Double volume;
    private Double latitude;
    private Double longitude;
    private String type;
    private String lepsius;
    private String material;
    private String comment;

    public Pyramid(String pharaoh, String ancient_name, String modern_name, Integer dynasty, String site, Double base1,
            Double base2, Double height, Double slope, Double volume, Double latitude, Double longitude, String type,
            String lepsius, String material, String comment) {
        this.pharaoh = pharaoh;
        this.ancient_name = ancient_name;
        this.modern_name = modern_name;
        this.dynasty = dynasty;
        this.site = site;
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.slope = slope;
        this.volume = volume;
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.lepsius = lepsius;
        this.material = material;
        this.comment = comment;

    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    };

    public void setAncient_name(String ancient_name) {
        this.ancient_name = ancient_name;
    };

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    };

    public void setDynasty(Integer dynasty) {
        this.dynasty = dynasty;
    };

    public void setSite(String site) {
        this.site = site;
    };

    public void setBase1(Double base1) {
        this.base1 = base1;
    };

    public void setBase2(Double base2) {
        this.base2 = base2;
    };

    public void setHeight(Double height) {
        this.height = height;
    };

    public void setSlope(Double slope) {
        this.slope = slope;
    };

    public void setVolume(Double volume) {
        this.volume = volume;
    };

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    };

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    };

    public void setType(String type) {
        this.type = type;
    };

    public void setLepsius(String lepsius) {
        this.lepsius = lepsius;
    };

    public void setMaterial(String material) {
        this.material = material;
    };

    public void setComment(String comment) {
        this.comment = comment;
    };

    public String getPharaoh() {
        return pharaoh;
    };

    public String getAncient_name() {
        return ancient_name;
    };

    public String getModern_name() {
        return modern_name;
    };

    public Integer getDynasty() {
        return dynasty;
    };

    public String getSite() {
        return site;
    };

    public Double getBase1() {
        return base1;
    };

    public Double getBase2() {
        return base2;
    };

    public Double getHeight() {
        return height;
    };

    public Double getSlope() {
        return slope;
    };

    public Double getVolume() {
        return volume;
    };

    public Double getLatitude() {
        return latitude;
    };

    public Double getLongitude() {
        return longitude;
    };

    public String getType() {
        return type;
    };

    public String getLepsius() {
        return lepsius;
    };

    public String getMaterial() {
        return material;
    };

    public String getComment() {
        return comment;
    };

}