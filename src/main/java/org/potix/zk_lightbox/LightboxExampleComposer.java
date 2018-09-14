package org.potix.zk_lightbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class LightboxExampleComposer extends SelectorComposer {
	
	private List<Map<String,String>> boxModel;

	/*doAfterCompose is called once the components have been created.
	 * This method can be used as an init method to prepare the page data*/
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		//Execute default init
		super.doAfterCompose(comp);
		
		//create the model object
		boxModel = new ArrayList<Map<String,String>>();
		
		//create each card data, and store it in the model object
		Map<String, String> card1 = new HashMap<String, String>();
		card1.put("templateUri","/templates/template1.zul");
		card1.put("templateText","This is the first card");
		boxModel.add(card1);

		Map<String, String> card2 = new HashMap<String, String>();
		card2.put("templateUri","/templates/template2.zul");
		card2.put("templateText","This is the second card");
		boxModel.add(card2);
		
		Map<String, String> card3 = new HashMap<String, String>();
		card3.put("templateUri","/templates/template1.zul");
		card3.put("templateText","This is the third card");
		boxModel.add(card3);
		
		Map<String, String> card4 = new HashMap<String, String>();
		card4.put("templateUri","/templates/template2.zul");
		card4.put("templateText","This is the fourth card");
		boxModel.add(card4);
	}
	
	/* private methods can be used to reduce code duplication.
	 * The same method can be called by multiple event listeners in the composer.
	 * In this case, a click on one link will cause the application
	 * to load a lightbox with the model data, and open it at the specified index*/
	private void openLightbox(int index, List<Map<String,String>> model){
		Map<String,Object> arguments = new HashMap<>();
		arguments.put("lightboxModel", model);
		arguments.put("selIndex", index);
		/* createComponents will generate ZK components based on a zul file (or other source)
		 * The arguments passed in this call (the model and selected index) will be available
		 * to the instantiated components */
		Executions.createComponents("/step3/lightboxdefinition.zul", this.getSelf(), arguments);
	}
	
	/* Event listeners for clicks on each of the anchors.
	 * For more details, please visit the following documentation page.
	 * https://www.zkoss.org/wiki/ZK_Developer's_Reference/MVC/Controller/Composer */
	@Listen("onClick=#l1")
	public void handleL1Click(){
		openLightbox(0, boxModel);
	}
	@Listen("onClick=#l2")
	public void handleL2Click(){
		openLightbox(1, boxModel);
	}
	@Listen("onClick=#l3")
	public void handleL3Click(){
		openLightbox(2, boxModel);
	}
	@Listen("onClick=#l4")
	public void handleL4Click(){
		openLightbox(3, boxModel);
	}
}
