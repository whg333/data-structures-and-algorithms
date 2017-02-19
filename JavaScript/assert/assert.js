function assert(value, desc) {
  appendResult(value ? "pass" : "fail", desc);
}

function info() {
  //var argsArray = Array.prototype.slice.call(arguments);转换arguments成数组
  for(var index in arguments){
    appendResult("info", arguments[index]);
    log(arguments[index]);
  }
}

function appendResult(className, desc) {
  var resultsList = document.getElementById("results");
  if (!resultsList) {
    resultsList = document.createElement('ul');
    document.getElementsByTagName('body')[0].appendChild(resultsList);
    resultsList.setAttribute('id','results');
  }
  var li = document.createElement("li");
  li.className = className;
  li.appendChild(document.createTextNode(desc));
  resultsList.appendChild(li);
}

function log() {
  try {
    console.log.apply(console, arguments);                  //#1
  }
  catch(e) {                                                //#2
    try {
      opera.postError.apply(opera, arguments);              //#3
    }
    catch(e){
      alert(Array.prototype.join.call( arguments, " "));    //#4
    }
  }
}