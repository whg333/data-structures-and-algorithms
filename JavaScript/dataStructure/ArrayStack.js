function ArrayStack(){
    this.array = [];
}

ArrayStack.prototype = {
    constructor:ArrayStack,
    push:function(){
        for(var index in arguments){
            if(arguments.hasOwnProperty(index)) {
                this.array.push(arguments[index]);
            }
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
    size:function(){
        return this.array.length;
    },
    clear:function(){
        this.array = [];
    },
    toString:function(){
        return "ArrayStack (array=["+this.array+"])";
    }
}