public class TestYourJson {

	public static void main(String[] args) {
		 String s="{\"name\":\"sonoo\",\"salary\":600000.0,\"age\":27}"; 
		 
		 String json = "{\"entities\":[{\"entity_type\":\"Offering\",\"properties\":{\"LastUpdateTime\":1643645817098,\"Id\":\"1005373\"},\"related_properties\":{}}],\"meta\":{\"completion_status\":\"OK\",\"total_count\":1,\"errorDetailsList\":[],\"errorDetailsMetaList\":[],\"query_time\":1643816205327446}}";
		 
		  //System.out.println(json);
		  
		  //String input ="{\\\"complexTypeProperties\\\":[{\\\"properties\\\":{\\\"Unnamed1_c\\\":\\\"CheckIn_c\\\"}}]}";
		  String userOptionsString = "{\\\"complexTypeProperties\\\":[{\\\"properties\\\":{\\\"Unnamed1_c\\\":\\\"CheckIn_c\\\"}}]}";
		  
		  
		  System.out.println(userOptionsString);
		    
//		  String offeringID = StringUtils.EMPTY;
//		    ObjectMapper objectMapper = new ObjectMapper();
//		    try {
//				SMAXOfferingResponse smaxOfferingResponse = objectMapper.readValue(json, SMAXOfferingResponse.class);
//				if(Objects.nonNull(smaxOfferingResponse.getEntities())) {
//					if(Objects.nonNull(smaxOfferingResponse.entities.get(0).properties)) {
//						offeringID = smaxOfferingResponse.entities.get(0).properties.getId();
//						System.out.println("OfferID:>"+offeringID);
//					}
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		    
	}

}
