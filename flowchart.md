# Electricity Bill Calculator Flowchart

## Flowchart Diagram

```mermaid
flowchart TD
    A[Start] --> B[Initialize constants: Rates and Limits]
    B --> C[Display program header and rate information]
    C --> D[Get user input for electricity usage]
    D --> E{Validate: usage < 0?}
    E -->|Yes| F[Display error message and return]
    E -->|No| G[Call calculateElectricityBill function]
    G --> H[Store result in totalBill]
    H --> I[Display calculation details and breakdown]
    I --> J[Calculate and display each tier cost]
    J --> K[Display service charge and total bill]
    K --> L[Close scanner and End program]
    F --> M[End program]
    
    G --> N[Inside calculateElectricityBill function]
    N --> O{usage <= FIRST_TIER_LIMIT?}
    O -->|Yes| P[Set electricityCost = usage * RATE_FIRST_TIER]
    O -->|No| Q{usage <= SECOND_TIER_LIMIT?}
    Q -->|Yes| R[Calculate cost for first and second tier]
    Q -->|No| S[Calculate cost for all three tiers]
    P --> T[Add SERVICE_CHARGE and return total]
    R --> T
    S --> T
    T --> H
```

## Description

The flowchart illustrates the flow of the Electricity Bill Calculator program:

1. **Initialization**: The program starts by defining constants for the electricity rates and tier limits
2. **User Interaction**: Displays the rate information and prompts the user for electricity usage
3. **Validation**: Checks if the input is valid (non-negative)
4. **Calculation**: Calls the calculation function which determines the cost based on the tiered pricing structure
5. **Output**: Displays a detailed breakdown of the charges and the total bill

The calculation logic follows a tiered approach:
- If usage is ≤ 150 units: Apply first tier rate to all units
- If usage is ≤ 400 units: Apply first tier rate to first 150 units, then second tier rate to remaining units
- If usage is > 400 units: Apply first tier rate to first 150 units, second tier rate to next 250 units, and third tier rate to remaining units
- Finally, add the fixed service charge to get the total bill