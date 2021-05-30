public class App {
    public static void main(String[] args) throws Exception {
        PyramidDao p_handler = new PyramidDaoImpl();
        for(Pyramid p : p_handler.getAllPyramids()){
            System.out.println(p.getModern_name());
        }
    }
}
