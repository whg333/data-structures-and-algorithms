function ArrayQueue(){
    this.array = [];
}

ArrayQueue.prototype = {
    constructor:ArrayQueue,
    enqueue:function(){
        for(var index in arguments){
            if(arguments.hasOwnProperty(index)) {
                this.array.push(arguments[index]);
            }
        }
    },
    dequeue:function(){
        return this.array.shift();
    },
    front:function(){
        return this.array[0];
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
        return "ArrayQueue (array=["+this.array+"])";
    }
}