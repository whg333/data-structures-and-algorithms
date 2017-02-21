function PriorityArrayQueue(){
    this.array = [];
}

function QueueElement(value, priority){
    this.value = value;
    this.priority = priority;
    this.toString = function(){
        return "QueueElement (value="+this.value+", priority="+this.priority+")";
    }
}

PriorityArrayQueue.prototype = {
    constructor:PriorityArrayQueue,
    enqueue:function(value, priority){
        var element = new QueueElement(value, priority);
        for(var i=0;i<this.array.length;i++){
            if(element.priority > this.array[i].priority){
                this.array.splice(i, 0, element);
                return;
            }
        }
        this.array.push(element);
    },
    dequeue:function(){
        return this.array.shift().value;
    },
    front:function(){
        return this.array[0].value;
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
        return "PriorityArrayQueue (array=["+this.array+"])";
    }
}