
public class container implements Comparable<container>{

private String containerUUID;
private String shortName;
private String longName;

public String getcontainerUUID(){
return containerUUID;
}

public String getshortName(){
return shortName;
}

public String getlongName(){
return longName;
}

public void setcontainerUUID(String containerUUID){
this.containerUUID = containerUUID;
}

public void setshortName(String shortName){
this.shortName = shortName;
}

public void setlongName(String longName){
this.longName = longName;
}

public container(){
}

@Override
public String toString(){
return "    <CONTAINER "  +this.getcontainerUUID() +  ">\n"+
        "        <SHORT-NAME>" + this.getshortName() + "</SHORT-NAME>\n"+
        "        <LONG-NAME>" + this.getlongName() + "</LONG-NAME>\n"+
        "    </CONTAINER>\n";
}

@Override
public int compareTo(container o){
if(this.getshortName().charAt(9)>o.getshortName().charAt(9)){
return 1;
}
else if(this.getshortName().charAt(9)<o.getshortName().charAt(9)){
return -1;
}
else {
return 0;
}
}

}
