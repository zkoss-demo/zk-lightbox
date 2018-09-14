package org.potix.zk_lightbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class LightboxGalleryComposer extends SelectorComposer {
	
	private List<Map<String,String>> boxModel;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		boxModel = new ArrayList<Map<String,String>>();
		
		Map<String, String> card1 = new HashMap<String, String>();
		card1.put("templateUri","/templates/imagetemplate.zul");
		card1.put("imageSource","/resources/pizza.png");
		card1.put("imageCaption","This is the first image");
		boxModel.add(card1);
		
		Map<String, String> card2 = new HashMap<String, String>();
		card2.put("templateUri","/templates/imagetemplate.zul");
		card2.put("imageSource","/resources/pasta.png");
		card2.put("imageCaption","This is the second image");
		boxModel.add(card2);
		
		Map<String, String> card3 = new HashMap<String, String>();
		card3.put("templateUri","/templates/imagetemplate.zul");
		card3.put("imageSource","/resources/salad.png");
		card3.put("imageCaption","This is the third image");
		boxModel.add(card3);
		
		Map<String, String> card4 = new HashMap<String, String>();
		card4.put("templateUri","/templates/imagetemplate.zul");
		card4.put("imageSource","/resources/sushi.png");
		card4.put("imageCaption","This is the fourth image");
		boxModel.add(card4);
	}
	
	private void openLightbox(int index, List<Map<String,String>> model){
		Map<String,Object> arguments = new HashMap<>();
		arguments.put("lightboxModel", model);
		arguments.put("selIndex", index);
		Executions.createComponents("/step4/lightboxdefinition.zul", this.getSelf(), arguments);
	}
	
	@Listen("onClick=#image1")
	public void handleL1Click(){
		openLightbox(0, boxModel);
	}
	@Listen("onClick=#image2")
	public void handleL2Click(){
		openLightbox(1, boxModel);
	}
	@Listen("onClick=#image3")
	public void handleL3Click(){
		openLightbox(2, boxModel);
	}
	@Listen("onClick=#image4")
	public void handleL4Click(){
		openLightbox(3, boxModel);
	}
	
	
}
