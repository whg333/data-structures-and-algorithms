function PriorityArrayQueue(){
    this.array = [];
}

function QueueItem(element, priority){
    this.element = element;
    this.priority = priority;
    this.toString = function(){
        return "QueueItem (element="+this.element+", priority="+this.priority+")";
    }
}

PriorityArrayQueue.prototype = {
    constructor:PriorityArrayQueue,
    enqueue:function(element, priority){
        var item = new QueueItem(element, priority);
        for(var i=0;i<this.array.length;i++){
            if(item.priority > this.array[i].priority){
                this.array.splice(i, 0, item);
                return;
            }
        }
        this.array.push(item);
    },
    dequeue:function(){
        return this.array.shift().element;
    },
    front:function(){
        return this.array[0].element;
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