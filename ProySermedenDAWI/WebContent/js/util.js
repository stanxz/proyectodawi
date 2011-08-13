//-------------Build HTML------------------------*

buildHTML = function(tag, html, attrs) {
    // you can skip html param
    if (typeof(html) != 'string') {
        attrs = html;
        html = null;
    }
    var h = '<' + tag;
    for (attr in attrs) {
        if(attrs[attr] === false) continue;
        h += ' ' + attr + '="' + attrs[attr] + '"';
    }
    return h += html ? ">" + html + "</" + tag + ">" : "/>";
}

function populateList( jsonRoot, propertyKey , propertyDesc , html , $List){
                    
    $.each(jsonRoot,function(key,val){
                        
        var $html= buildHTML(html,val[propertyDesc],{
            'id':val[propertyKey],
            'title':val[propertyDesc]
        });
                        
        $List.append($html);                       
    });
}


function jsonPropertyByID(jsonRoot , keyVal , valueVal ){
    var flag = false;
    var value;
                    
    $.each(jsonRoot, function(key,val){
        if(val[keyVal] == valueVal){
            value = val;
            flag = true;
        }
                        
        if(flag) return false;
    }); 
    return value;
                    
}

function getUrlVars(){
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}

function getValor(val, def) {
    if(def == undefined || def == null) {
        def = '';
    }
    if(val == undefined || val == null){
        return def;
    }
    return val;
}

function log(msg) {
    console.log(msg);
}

