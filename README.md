# Electricity Bill Calculator

A Java program to calculate electricity bills based on usage in kilowatt-hours (kWh) with tiered pricing.

## Pricing Structure

- **0-150 units**: 3.50 baht/unit
- **151-400 units**: 4.20 baht/unit  
- **401+ units**: 5.00 baht/unit
- **Service charge**: 50.00 baht (fixed)

## Files Included

1. **ElectricityBillCalculator.java** - Main calculator program with interactive input
2. **ElectricityBillTest.java** - Test program with predefined usage scenarios
3. **README.md** - This documentation file

## How to Compile and Run

### Method 1: Interactive Calculator
```bash
javac ElectricityBillCalculator.java
java ElectricityBillCalculator
```

Then enter your electricity usage when prompted.

### Method 2: Run Test Cases
```bash
javac ElectricityBillTest.java
java ElectricityBillTest
```

This will run several test cases with different usage amounts.

## Sample Output

```
=== Electricity Bill Calculator ===
Electricity rates:
• 0-150 units: 3.50 baht/unit
• 151-400 units: 4.20 baht/unit
• 401+ units: 5.00 baht/unit
Service charge: 50.00 baht (fixed)

Enter electricity usage (kWh): 250

=== Bill Calculation Details ===
Electricity usage: 250.00 kWh
Calculation breakdown:
  0-150 units × 3.50 = 525.00 baht
  151-250 units × 4.20 = 420.00 baht
Electricity cost subtotal: 945.00 baht
Service charge: 50.00 baht
------------------------
Total bill: 995.00 baht
```

## Features

- ✅ Tiered pricing calculation
- ✅ Detailed bill breakdown
- ✅ Input validation
- ✅ Clear formatting with baht currency
- ✅ Service charge addition
- ✅ Comprehensive test cases
- ✅ Well-documented code with JavaDoc comments

## Program Structure

The calculator uses a tiered approach:
1. **First tier** (0-150): Simple multiplication
2. **Second tier** (151-400): First tier amount + remaining units at second rate
3. **Third tier** (401+): Both previous tiers + remaining units at highest rate

All calculations include the fixed 50 baht service charge.

## Pseudocode

### English Version:
```
START
  DECLARE constants for rates and service charge
  INPUT electricity usage in kWh
  
  IF usage < 0 THEN
    DISPLAY error message
    STOP
  END IF
  
  CALCULATE electricity cost based on usage tiers:
    IF usage <= 150 THEN
      cost = usage * 3.50
    ELSE IF usage <= 400 THEN
      cost = (150 * 3.50) + ((usage - 150) * 4.20)
    ELSE
      cost = (150 * 3.50) + (250 * 4.20) + ((usage - 400) * 5.00)
    END IF
  
  ADD service charge to total cost
  DISPLAY detailed breakdown and total bill
END
```

### Thai Version:
```
เริ่มต้น
  ประกาศค่าคงที่สำหรับอัตราค่าไฟฟ้าและค่าบริการ
  รับค่าการใช้งานไฟฟ้าเป็น kWh
  
  ถ้าการใช้งาน < 0 แล้ว
    แสดงข้อความผิดพลาด
    หยุด
  จบถ้า
  
  คำนวณค่าไฟฟ้าตามช่วงการใช้งาน:
    ถ้าการใช้งาน <= 150 แล้ว
      ค่าใช้จ่าย = การใช้งาน * 3.50
    ไม่งั้นถ้าการใช้งาน <= 400 แล้ว
      ค่าใช้จ่าย = (150 * 3.50) + ((การใช้งาน - 150) * 4.20)
    ไม่งั้น
      ค่าใช้จ่าย = (150 * 3.50) + (250 * 4.20) + ((การใช้งาน - 400) * 5.00)
    จบถ้า
  
    เพิ่มค่าบริการเข้ากับราคารวม
    แสดงรายละเอียดและการคิดเงินรวม
สิ้นสุด
```