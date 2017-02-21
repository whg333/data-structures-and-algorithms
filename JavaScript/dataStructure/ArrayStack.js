function ArrayStack(){
    this.array = [];
}

ArrayStack.prototype = {
    constructor:ArrayStack,
    push:function(){
        for(var index in arguments){
            this.array.push(arguments[index]);
        }
    },
    pop:function(){
        return this.array.pop();
    },
    peek:function(){
        return this.array[this.array.length-1];
    },
    isEmpty:function(){
        return this.array.length == 0;
    },
    clear:function(){
        this.array = [];
    },
    size:function(){
        return this.array.length;
    },
    toString:function(){
        return "ArrayStack (array=["+this.array+"])";
    }
}