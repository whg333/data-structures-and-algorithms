function ObjectDictionary(name){
    if(name){
        this.name = name;
    }else{
        this.name = "ObjectDictionary";
    }
    this.obj = {};
    this.length = 0;
}

ObjectDictionary.prototype = {
    constructor:ObjectDictionary,
    put:function(key, value){
        if(this.has(key)){
            var old = this.obj[key];
            this.obj[key] = value;
            return old;
        }else{
            this.obj[key] = value;
            this.length++;
            return undefined;
        }
    },
    remove:function(key){
        if(!this.has(key)){
            return undefined;
        }
        var old = this.obj[key];
        delete this.obj[key];
        this.length--;
        return old;
    },
    has:function(key){
        //return element in this.obj;
        return this.obj.hasOwnProperty(key);
    },
    get:function(key){
        return this.has(key) ? this.obj[key] : undefined;
    },
    isEmpty:function(){
        return this.length == 0;
    },
    size:function(){
        return this.length;
    },
    clear:function(){
        this.obj = {};
        this.length = 0;
    },
    keys:function(){
        var array = [];
        for(var key in this.obj){
            if(this.has(key)){
                array.push(key);
            }
        }
        return array;
    },
    values:function(){
        var array = [];
        for(var key in this.obj){
            if(this.has(key)){
                array.push(this.obj[key]);
            }
        }
        return array;
    },
    toString:function(){
        var entrySetstr = '';
        for(var key in this.obj){
            if(this.has(key)) {
                entrySetstr += (key+'='+this.obj[key]+',');
            }
        }
        return this.name+" (entrySet={"+entrySetstr+"})";
    }
}