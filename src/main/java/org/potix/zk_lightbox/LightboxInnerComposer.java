package org.potix.zk_lightbox;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zkmax.zul.Cardlayout;

public class LightboxInnerComposer extends SelectorComposer<Component> {
	
	@Wire
	Cardlayout card;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		
		card.setSelectedIndex(Integer.class.cast(Executions.getCurrent().getArg().get("selIndex")));
	}
	
	@Listen("onClick=#right")
	public void doRightArrow(){
		if(card.getSelectedIndex() == (card.getChildren().size()-1)){
			card.setSelectedIndex(0);
		}else{
			card.next();
		}
	}
	@Listen("onClick=#left")
	public void doLeftArrow(){
		if(card.getSelectedIndex() == 0){
			card.setSelectedIndex(card.getChildren().size()-1);
		}else{
			card.previous();
		}
	}
}