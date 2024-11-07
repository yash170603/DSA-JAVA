Let me outline the key properties of AND and OR operations when applied to an entire array:

AND Properties:
1. **Upper Bound**: 
   - Result ≤ minimum element in array
   - Because: any 0 bit in any number makes that bit 0 in final result

2. **Monotonically Decreasing**:
   - Adding more numbers to AND operation can only decrease or keep the same result
   - Because: more numbers = more chances of 0 bits

3. **Zero Property**:
   - If any number is 0, result is 0
   - Because: 0 has all bits as 0

4. **Identity**: 
   - AND with all 1s keeps number unchanged
   - x & (11111...) = x

OR Properties:
1. **Lower Bound**:
   - Result ≥ maximum element in array
   - Because: any 1 bit in any number makes that bit 1 in final result

2. **Monotonically Increasing**:
   - Adding more numbers to OR operation can only increase or keep the same result
   - Because: more numbers = more chances of 1 bits

3. **Unity Property**:
   - If any number is all 1s, result is all 1s
   - Because: OR with 1 makes everything 1

4. **Identity**:
   - OR with 0 keeps number unchanged
   - x | 0 = x

Common Properties:
1. **Associative**: 
   - Order doesn't matter
   - (a & b) & c = a & (b & c)
   - (a | b) | c = a | (b | c)

2. **Commutative**:
   - Sequence doesn't matter
   - a & b = b & a
   - a | b = b | a

3. **Idempotent**:
   - Repeating same number has no effect
   - a & a = a
   - a | a = a

These properties are often useful in solving bit manipulation problems and optimizing algorithms.
