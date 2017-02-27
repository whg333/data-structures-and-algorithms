function ObjectSet(name){
    if(name){
        this.name = name;
    }else{
        this.name = "ObjectSet";
    }
    this.obj = {};
    this.length = 0;
}

//测试Object添加原型属性不加hasOwnProperty过滤直接使用in操作符的影响
//Object.prototype.name1='name';

ObjectSet.prototype = {
    constructor:ObjectSet,
    add:function(){
        if(arguments.length == 1){
            return this._addElement(arguments[0]);
        }

        var result = false;
        for(var index in arguments){
            if(arguments.hasOwnProperty(index)){
                if(this._addElement(arguments[index])){
                    result = true;
                }
            }
        }
        return result;
    },
    _addElement:function(element){
        if(this.has(element)){
            return false;
        }
        this.obj[element] = null;
        this.length++;
        return true;
    },
    remove:function(element){
        if(!this.has(element)){
          return false;
        }
        delete this.obj[element];
        this.length--;
        return true;
    },
    has:function(){
        if(arguments.length <= 0){
            return false;
        }
        for(var index in arguments){
            if(arguments.hasOwnProperty(index)){
                if(!this._hasElement(arguments[index])){
                    return false;
                }
            }
        }
        return true;
    },
    _hasElement:function(element){
        //return element in this.obj;
        return this.obj.hasOwnProperty(element);
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
    values:function(){
        var array = [];
        for(var key in this.obj){
            if(this.has(key)){
                array.push(key);
            }
        }
        return array;
    },
    toString:function(){
        return this.name+" (values=["+this.values()+"])";
    },

    union:function(otherSet){
        var result = new ObjectSet("union");
        //result.add(this.values());
        //result.add(otherSet.values());
        //由于values返回的是数组，所以使用apply来调用add；
        //直接调用add的话，会把整个values数组当做1个参数而不是多个参数
        this.add.apply(result, this.values());
        this.add.apply(result, otherSet.values());
        return result;
    },
    intersection:function(otherSet){
        var result = new ObjectSet("intersection");
        var values = this.values();
        for(var index in values){
            if(otherSet.has(values[index])){
                result.add(values[index]);
            }
        }
        return result;
    },
    difference:function(otherSet){
        var result = new ObjectSet("difference");
        var values = this.values();
        for(var index in values){
            if(!otherSet.has(values[index])){
                result.add(values[index]);
            }
        }
        return result;
    },
    isSubsetOf:function(otherSet){
        if(this.size() > otherSet.length){
            return false;
        }
        var values = this.values();
        for(var index in values){
            if(!otherSet.has(values[index])){
                return false;
            }
        }
        return true;
    }
}