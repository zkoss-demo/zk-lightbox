zk.afterLoad('zkmax.layout', function(a) {
		var xCardlayout = {};
		zk.override(zkmax.layout.Cardlayout.prototype, xCardlayout ,{
			_animateShift : function(index) {
				var wgt = this;
                innerPannels = jq(this).find(".z-cardlayout-inner");
				if(Math.abs(this.getSelectedIndex() - index)<= 1){
					var result = xCardlayout._animateShift.apply(this, arguments);
				}else{
					var hr = this.isHorizontal(),
					diff = this.getSelectedIndex() - index,
					distance = Math.abs(diff) * (hr ? this.$n().offsetWidth : this.$n().offsetHeight),
					offset = diff > 0 ? '+=' + distance : '-=' + distance;
					
                	jq(innerPannels[index]).css({opacity:0});
                	
                	if (hr) {
            			jq('#' + this.uuid + '> .' + this.$s('inner')).css({left: offset});
            		} else {
            			jq('#' + this.uuid + '> .' + this.$s('inner')).css({top:offset});
            		}
                	
                }

                var i;
                for (i = 0; i < innerPannels.length; i++) {
                	jq(innerPannels[i]).animate({
                        opacity: (i==index?1:0.5)
                    }, {duration: zk(this).getAnimationSpeed("slow"), queue: false},function(){zUtl.fireSized(wgt)});
                }
				return result;
			}
		});//zk.override
	});//zk.afterLoad