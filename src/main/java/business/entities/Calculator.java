package business.entities;

public class Calculator {
double totalPrice;
int orderId = 0;

public void createOrder(int customerId, int length, int width, int incline, int roofTileType, int withShed, int shedLength, int shedWidth, int shedWallType, int shedFloorType, String comments){


    // sql statement: INSERT INTO orders(`customerId`, `length`, `width`, `incline`, `roofTileType`, `withShed`, `shedLength`, `shedWidth`, `shedWallType`, `shedFloorType`, `comments`) values (?,?,?,?,?,?,?,?,?,?,?); SELECT LAST_INSERT_ID();
    // should return the auto increment orderId from the new order - which we will store in the orderId var.
    // orderId should then have a value other than 0


    if (incline == 0){
        totalPrice = calcCarportFlatRoof(length,width,withShed,shedLength,shedWidth);
    }
    else{
//        totalPrice = calcCarportRoof(length,width,withShed,shedLength,shedWidth,incline,roofTileType);
        return;     //we need a method to sort how it works, if theres an incline, should take rooftiles into account and stuff.
    }

}









    public double calcCarportFlatRoof(int length, int width, int withShed, int shedLength, int shedWidth) {
    int tempValue;
    int tempQuantity;
    int tempValue2 = 0;     //bruges til at gemme totalt antal af løsholtere, til antal af vinkelbeslag
    double totalPrice = 0;
    double tempPrice = 100;

    //1. material (understern front)  - DONE
        tempValue = width/2 +1;
        tempQuantity = 4;
        while (tempValue%30 != 0)
            tempValue = tempValue +1;
//        tempPrice = getPrice(1);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        insertToBOM(orderId, 1,tempValue,tempQuantity,tempPrice);
        totalPrice = totalPrice + tempPrice;

        System.out.println(tempPrice);



    //2. material (understern siderne) - DONE
        tempValue = length/2 +1;
        tempQuantity = 4;
        while (tempValue%30 != 0)
            tempValue = tempValue +1;
        tempPrice = getPrice(2);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        insertToBOM(orderId, 2,tempValue,tempQuantity,tempPrice);
        totalPrice = totalPrice + tempPrice;


    //3. material (overstern forenden) - DONE
        tempValue = width/2 +1;
        tempQuantity = 2;
        while (tempValue%30 != 0)
            tempValue = tempValue +1;
        tempPrice = getPrice(3);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        insertToBOM(orderId, 3,tempValue,tempQuantity,tempPrice);
        totalPrice = totalPrice + tempPrice;

    //4. material (overstern siderne) - DONE
        tempValue = length/2 +1;
        tempQuantity = 4;
        while (tempValue%30 != 0)
            tempValue = tempValue +1;
        tempPrice = getPrice(4);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        insertToBOM(orderId, 4,tempValue,4,tempPrice);
        totalPrice = totalPrice + tempPrice;



    //5. material (Til z på bagside af dør) - DONE
        if(withShed == 1){
            tempValue = 420;
            tempQuantity = 1;
            tempPrice = getPrice(5);
            tempPrice = (tempPrice*tempValue*tempQuantity)/100;
            insertToBOM(orderId, 5,tempValue,tempQuantity,tempPrice);
            totalPrice = totalPrice + tempPrice;

        }

    //6. material (løsholder til skur gavle)  - DONE

        if(withShed == 1){
            tempQuantity = 6;
            if (shedWidth > 330){
                tempQuantity = 12;
                tempValue = shedWidth/2 + 1;
                while (tempValue%30 != 0)
                    tempValue = tempValue +1;
            }
            tempPrice = getPrice(6);
            tempPrice = (tempPrice*tempValue*tempQuantity)/100;
            insertToBOM(orderId,6,tempValue,tempQuantity,tempPrice);
            totalPrice = totalPrice + tempPrice;
            tempValue2 = tempQuantity;

        }

    //7. material (løsholder til skur sider) - DONE

        if(withShed == 1){
            tempQuantity = 4;
            tempValue = shedLength;
            tempPrice = getPrice(7);
            tempPrice = (tempPrice*tempValue*tempQuantity)/100;
            insertToBOM(orderId,7,tempValue,tempQuantity,tempPrice);
            totalPrice = totalPrice + tempPrice;
            tempValue2 = tempValue2 + tempQuantity;

        }

    //8. material (Remme i sider) - DONE

        tempValue = length;
        if(length > 720){
            tempValue = 600;
        }
        tempQuantity = 2;
        tempPrice = getPrice(8);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        totalPrice = totalPrice + tempPrice;
        insertToBOM(orderId,8,tempValue,tempQuantity,tempPrice);


    //9. material (Remme i sider) skal med hvis den er over 720 lang. - DONE

        if(length > 720){
            tempValue = 390;
            tempQuantity = 1;
            tempPrice = getPrice(9);
            tempPrice = (tempPrice*tempValue*tempQuantity)/100;
            totalPrice = totalPrice + tempPrice;
            insertToBOM(orderId,9,tempValue,tempQuantity,tempPrice);

        }


    //10. material (spær) - DONE

        tempValue = width;
        tempQuantity = (length-5)/55;          //runder ned, så vi plusser 1
        tempQuantity = tempQuantity+1;
        tempPrice = getPrice(10);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        totalPrice = totalPrice + tempPrice;
        insertToBOM(orderId,10,tempValue,tempQuantity,tempPrice);


    //11. material (stolper) - DONE

        tempQuantity = 4;
        if(length > 550){
            tempQuantity = 6;
        }
        if(withShed == 1){
            tempQuantity = 11;
        }
        if(withShed == 1 && width > 330){
            tempQuantity = 9;
        }
        tempPrice = getPrice(11);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        totalPrice = totalPrice + tempPrice;
        insertToBOM(orderId,11,tempValue,tempQuantity,tempPrice);



    //12. material (beklædning af skur) - DONE

        if(withShed == 1){
            tempValue = (shedLength*2 + shedWidth*2)/100;
            tempValue = tempValue*13;
            tempPrice = getPrice(12);
            tempPrice = (tempPrice*210*tempValue)/100;
            totalPrice = totalPrice + tempPrice;
            insertToBOM(orderId,12,210,tempValue,tempPrice);
        }




    //13. material (vandbræt på stern i sider)

        tempValue = width/2 +1;
        tempQuantity = 4;
        while (tempValue%30 != 0)
            tempValue = tempValue +1;
//      tempPrice = getPrice(13);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        insertToBOM(orderId, 13,tempValue,tempQuantity,tempPrice);
        totalPrice = totalPrice + tempPrice;



    //14. material (vandbræt på stern i forende)

        tempValue = length/2 +1;
        tempQuantity = 2;
        while (tempValue%30 != 0)
            tempValue = tempValue +1;
        tempPrice = getPrice(14);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        insertToBOM(orderId, 14,tempValue,tempQuantity,tempPrice);
        totalPrice = totalPrice + tempPrice;


    //15. material (tagplader på spær)


        tempValue = length;
        while(tempValue%30 != 0)
            tempValue = tempValue + 1;
        if(length > 600){
            tempValue = 600;
        }
        tempQuantity = width/100;
        tempQuantity = tempQuantity + 1;
        tempPrice = getPrice(15);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        insertToBOM(orderId,15,tempValue,tempQuantity,tempPrice);
        totalPrice = totalPrice + tempPrice;




    //16. material (tagplader på spær)

        if(length > 600 && length < 720){
            tempValue = 240;
        }
        else{
            tempValue = 360;
        }
        tempQuantity = width/100;
        tempQuantity = tempQuantity + 1;
        tempPrice = getPrice(16);
        tempPrice = (tempPrice*tempValue*tempQuantity)/100;
        insertToBOM(orderId,16,tempValue,tempQuantity,tempPrice);
        totalPrice = totalPrice + tempPrice;



    //metals

    //17. material (skruer til tagplader)

        tempValue = (length*width)/10000;
        tempValue = tempValue*12;
        tempValue = (tempValue/200);
        tempValue = tempValue + 1; //da den runder ned
        tempPrice = getPrice(17);
        tempPrice = tempPrice*tempQuantity;
        insertToBOMOther(orderId,17,tempQuantity,tempPrice);
        totalPrice = totalPrice + tempPrice;


    //18. material (hulbånd til vindkryds på spær)

        tempPrice = getPrice(18);
        tempPrice = tempPrice*2;
        insertToBOMOther(orderId,18,2,tempPrice);
        totalPrice = totalPrice + tempPrice;


    //19. material (montering af spær på rem)

        tempQuantity = (length-5)/55;          //runder ned, så vi plusser 1
        tempQuantity = tempQuantity+1;
        tempPrice = getPrice(19);
        tempPrice = tempPrice*tempQuantity;
        totalPrice = totalPrice + tempPrice;
        insertToBOMOther(orderId,19,tempQuantity,tempPrice);


    //20. material (montering af spær på rem)

        tempQuantity = (length-5)/55;          //runder ned, så vi plusser 1
        tempQuantity = tempQuantity+1;
        tempPrice = getPrice(20);
        tempPrice = tempPrice*tempQuantity;
        totalPrice = totalPrice + tempPrice;
        insertToBOMOther(orderId,20,tempQuantity,tempPrice);


    //21. material (montering af stærn&vandbrædt)           //altid 1 pakke skruer, fås ikke mindre

        tempPrice = getPrice(21);
        totalPrice = totalPrice + tempPrice;
        insertToBOMOther(orderId,21,1,tempPrice);


    //22. material (Til	montering	af	universalbeslag	+	hulbånd)  //hver gang vi har 1 spær, skal vi bruge ca. 40 skruer

        tempQuantity = (length-5)/55;
        tempQuantity = tempQuantity+1;
        tempQuantity = (tempQuantity*40)/250;
        tempQuantity = tempQuantity + 1;
        tempPrice = getPrice(22);
        tempPrice = tempPrice*tempQuantity;
        totalPrice = totalPrice + tempPrice;
        insertToBOMOther(orderId,22,tempQuantity,tempPrice);



    //23. material (montering af rem på stolper)

        if(length > 720){
            tempQuantity = 20;
        }
        if(length > 550 && length <= 720){
            tempQuantity = 12;
        }
        else{
            tempQuantity = 8;
        }
        tempPrice = getPrice(23);
        tempPrice = tempPrice * tempQuantity;
        totalPrice = totalPrice + tempPrice;
        insertToBOMOther(orderId,23,tempQuantity,tempPrice);


    //24. material (Til	montering	af	rem	på	stolper) //tror der er fejl i deres tegning.


        tempPrice = getPrice(24);
        tempPrice = tempPrice * tempQuantity;
        totalPrice = totalPrice + tempPrice;
        insertToBOMOther(orderId,24,tempQuantity,tempPrice);


    //25. material (skruer til montering af ydre beklædning af skur)

        if(withShed == 1){
            tempQuantity = (shedLength*2 + shedWidth*2)/100;
            tempQuantity = tempQuantity*13;
            tempQuantity = (tempQuantity/2)+1;    //halvdelen af bræderne skal være yderst, så de skal have andre skruer
            tempQuantity = tempQuantity*6;  //6 skruer per bræt
            tempQuantity = (tempQuantity/400)+1;
            tempPrice = getPrice(25);
            tempPrice = tempPrice * tempQuantity;
            insertToBOMOther(orderId,25,tempQuantity,tempPrice);
            totalPrice = totalPrice + tempPrice;
        }

    //26. material (kruer til montering af indre beklædning af skur)

        if(withShed == 1){
            tempQuantity = (shedLength*2 + shedWidth*2)/100;
            tempQuantity = tempQuantity*13;
            tempQuantity = (tempQuantity/2)+1;    //halvdelen af bræderne skal være yderst, så de skal have andre skruer
            tempQuantity = tempQuantity*6;  //6 skruer per bræt
            tempQuantity = (tempQuantity/300)+1;
            tempPrice = getPrice(26);
            tempPrice = tempPrice * tempQuantity;
            insertToBOMOther(orderId,25,tempQuantity,tempPrice);
            totalPrice = totalPrice + tempPrice;
        }


    //27. og 28. material (til skurdør)

        if(withShed == 1){

            tempPrice = getPrice(27);
            totalPrice = totalPrice + tempPrice;
            insertToBOMOther(orderId,27,1,tempPrice);

            tempPrice = getPrice(28);
            tempPrice = tempPrice*2; //da der er 2 hængsler
            totalPrice = totalPrice + tempPrice;
            insertToBOMOther(orderId,28,2,tempPrice);
        }



    //29. material (til montering af løsholter i skur)

        if(withShed == 1){
            tempQuantity = tempValue2 * 2;
            tempPrice = getPrice(29);
            tempPrice = totalPrice * tempQuantity;
            totalPrice = totalPrice + tempPrice;
            insertToBOMOther(orderId,29,tempQuantity,tempPrice);
        }

        return totalPrice;


}



    //totalPrice = calcCarportRoof(length,width,withShed,shedLength,shedWidth,incline,roofTileType);

    //public double calcCarportRoof(,,,,,,,)


    public double getPrice(int materialId){
    return 1.00;
    // sql statement: SELECT `Price per unit/measurement` from Materials WHERE idMaterial = "?";
    }




    public void insertToBOM(int orderId, int idMaterial, int length, int quantity, double price){

    // sql statement: INSERT INTO BOM(`ìdOrder`,`idMaterial`,`length`,`quantity`,`price`) values (?,?,?,?,?)


    }


    public void insertToBOMOther(int orderId, int idMaterial, int quantity, double price){

        // sql statement: INSERT INTO BOM(`ìdOrder`,`idMaterial`,`quantity`,`price`) values (?,?,?,?)


    }


}


