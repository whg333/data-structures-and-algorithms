function ObjectSet(){
    this.obj = {};
    this.length = 0;
}

//测试Object添加原型属性不加hasOwnProperty过滤直接使用in操作符的影响
//Object.prototype.name1='name';

ObjectSet.prototype = {
    constructor:ObjectSet,
    addAll:function(){
        for(var index in arguments){
            if(arguments.hasOwnProperty(index)){
                this.add(arguments[index]);
            }
        }
    },
    add:function(element){
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
    has:function(element){
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
        return "ObjectSet (values=["+this.values()+"])";
    }
}