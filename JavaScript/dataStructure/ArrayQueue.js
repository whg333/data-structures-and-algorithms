function ArrayQueue(){
    this.array = [];
}

ArrayQueue.prototype = {
    constructor:ArrayQueue,
    enqueue:function(){
        for(var index in arguments){
            this.array.push(arguments[index]);
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
    clear:function(){
        this.array = [];
    },
    size:function(){
        return this.array.length;
    },
    toString:function(){
        return "ArrayQueue [array="+this.array+"]";
    }
}