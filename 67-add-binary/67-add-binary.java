class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder();
        int ia=a.length()-1;
        int ib=b.length()-1;
        boolean carry=false;
        while(ia>=0 || ib>=0){
            if(ia>=0 && ib>=0){
                char a1=a.charAt(ia--);
                char a2=b.charAt(ib--);
                char res='0';
                if(a1=='1' && a2=='1' && carry){
                    res='1';
                    carry=true;
                }
                else if(a1=='1' && a2=='1' && !carry){
                    carry=true;
                }
                else if(a1=='0' && a2=='0' && carry){
                    res='1';
                    carry=false;
                }
                else if(a1=='1' && a2=='0' && !carry){
                    res='1';
                    carry=false;
                }
                else if(a2=='1' && a1=='0' && !carry){
                     res='1';
                    carry=false;
                }
                sb.append(res);
            }
            else if(ia<0){
                char a2=b.charAt(ib--);
                char res='0';
                if(a2=='1' && carry){
                    carry=true;
                }
                else if(a2=='0' && carry){
                    res='1';
                    carry=false;
                }
                else if(a2=='1' && !carry){
                     res='1';
                    carry=false;
                }
                sb.append(res);
            }
            else{
                 char a1=a.charAt(ia--);
                char res='0';
                if(a1=='1' && carry){
                    carry=true;
                }
                else if(a1=='0' && carry){
                    res='1';
                    carry=false;
                }
                else if(a1=='1' && !carry){
                    res='1';
                    carry=false;
                }
                sb.append(res);
            }
                
            }
        if(carry){
            sb.append('1');
        }
        return sb.reverse().toString();
        }
    }
