/*
JQXHTML V 0.1

Jqxhtml is a jquery extension that fix IE innerHTML non valid code.
it can be used like jquery html() methode . 

this is a first release  I only tested ir on some html examples with IE6 and IE7
I wrote the minimum JS code to keep it as efficient as possible 

comments and suggestions are welcome
*/

jQuery.fn.extend({
xhtml: function( val ) {

	function lower() {			
		return '<'+arguments[1].toLowerCase()+arguments[2] +'>';
	}	
	
	function quoteAttr() {
		attributes = arguments[2];
		attributes = attributes.replace(/(.+)=([^"].+[^"])\s+/ig, '$1="$2" '); 
		attributes = attributes.replace(/\s+(.+)=([^"].+[^"])/ig, ' $1="$2"'); 
		return '<' + arguments[1].toLowerCase() + ' ' + attributes +'>';
	}	

	
	if (val == undefined)
	{
		if (this.length == 0) return null;
		string = this[0].innerHTML;
		if (jQuery.browser.msie) 
		{
			string = string.replace(/<(\/?\w+)(\s*[^>]*)>/igm, lower); //fix attributes : add quotes				
			
			string = string.replace(/<(img|input)\s(.+)\B>/igm,'<$1 $2/>'); //fix tags that don't need closing tags
			string = string.replace(/<\/(img|input)>/igm,''); 
	
			//TODO : is there a way to do it without callback ?
			string = string.replace(/<(\/?\w+)\s+([^>]*)>/igm, quoteAttr); //fix attributes : add quotes
			
			string = string.replace(/<li>/igm,'</li>\n<li>'); //fix lists : first add closing /LI to all list elements
			string = string.replace(/(<ul>(\s*)<\/li>)/igm,'<ul>'); //fix lists : then remove the one folowing UL
			string = string.replace(/(<\/li>(\s*)<\/li>)/igm,'</li>'); //fix lists : then remove the one folowing UL
			
		}
		return string;		
	}
	else this.empty().append( val );
}

});
