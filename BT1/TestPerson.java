package BT1;

public class TestPerson {
    public static void main(String[] args) {
        Person[]ds=new Person[5];
        ds[0]=new SinhVien("Nguyen Van A","123ST",2003,"25CE1",7.1);
        ds[1]=new SinhVien("Nguyen Van B","123ST2",2004,"25CE2",8.2);
        ds[2]=new SinhVien("Nguyen Van C","123ST4",2005,"25CE3",9.3);
        ds[3]=new GiangVien("Tran A","123SS",1999,"1234Ce",20);
        ds[4]=new GiangVien("Tran B","124SG",1998,"1235cg",25);
        for(int i=0;i<ds.length;i++){
            ds[i].inThongTin();
        }
    }
        }
