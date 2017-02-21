function LinkedList(){
    this.header = new Node(null, null);
    this.length = 0;
}

function Node(element, next){
    this.element = element;
    this.next = next;
}

LinkedList.prototype = {
    constructor:LinkedList,
    append:function(element){
        var newNode = new Node(element, null);
        var curr = this.header.next;
        if(curr == null){
            this.header.next = newNode;
        }else{
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
        this.length++;
    },
    insert:function(index, element){
        this._checkLength(index);
        var indexPrevious = this.indexAt(index-1);
        indexPrevious.next = new Node(element, indexPrevious.next);
        this.length++;
    },
    indexAt:function(index){
        this._checkLength(index);
        var curr = this.header.next;
        for(var i=0;i<index;i++){
            curr = curr.next
        }
        return curr;
    },
    remove:function(element){
        var curr = this.header.next;
        if(curr == null) return false;

        var previous = this.header;
        for(var i=0;curr!=null;i++){
            if(curr.element == element){
                previous.next = curr.next;
                this.length--;
                return true;
            }
            previous = curr;
            curr = curr.next;
        }
        return false;
    },
    removeAt:function(index){
        this._checkLength(index);
        var indexPrevious = this.indexAt(index-1);
        indexPrevious.next = indexPrevious.next.next;
        this.length--;
    },
    indexOf:function(element){
        var curr = this.header.next;
        if(curr == null) return -1;

        for(var i=0;curr!=null;i++){
            if(curr.element == element){
                return i;
            }
            curr = curr.next;
        }
        return -1;
    },
    isEmpty:function(){
        return this.length == 0;
    },
    clear:function(){
        this.header.next = null;
        this.length = 0;
    },
    size:function(){
        return this.length;
    },
    toString:function(){
        var eleStr = '';
        var curr = this.header.next;
        if(curr != null){
            eleStr += (curr.element);
            while(curr.next != null){
                eleStr += ', ';
                curr = curr.next;
                eleStr += (curr.element);
            }
        }
        return "LinkedList (elements=["+eleStr+"])";
    },
    _checkLength:function(index){
        if(index < 0 || index > this.length-1){
            throw new Error("OutOfIndex : index="+index+", length="+this.length);
        }
    }
}