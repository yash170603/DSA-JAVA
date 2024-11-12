Binary search variations can indeed be confusing due to subtle differences in conditions and outcomes. Here’s a structured list of common variations, along with their use cases and how they differ from each other.


---

1. Exact Match (Conventional Binary Search)

int left = 0;
int right = arr.size() - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr.get(mid) == target) {
        return mid; // Target found
    } else if (arr.get(mid) < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}

return -1; // Target not found

Goal: Find the exact index of the target element.

End Condition: Loop exits when left > right, indicating target is not in the array.

Use Case: Use this when you want to know if target exists and need its exact position.



---

2. Lower Bound (First Position ≥ Target)

int left = 0;
int right = arr.size();

while (left < right) {
    int mid = left + (right - left) / 2;
    if (arr.get(mid) < target) {
        left = mid + 1;
    } else {
        right = mid;
    }
}

return left;

Goal: Find the smallest index where arr.get(left) >= target.

End Condition: Loop exits when left == right. left now points to the first position where arr.get(left) >= target.

Use Case: Use this when you need the insertion point for target if it’s not found. Useful for finding the first occurrence or finding where to insert to maintain sorted order.



---

3. Upper Bound (First Position > Target)

int left = 0;
int right = arr.size();

while (left < right) {
    int mid = left + (right - left) / 2;
    if (arr.get(mid) <= target) {
        left = mid + 1;
    } else {
        right = mid;
    }
}

return left;

Goal: Find the smallest index where arr.get(left) > target.

End Condition: Loop exits when left == right. left now points to the first position where arr.get(left) > target.

Use Case: Useful for finding the last occurrence of target or insertion point if target needs to be after all its equal elements.



---

4. Find Last Position ≤ Target

int left = 0;
int right = arr.size() - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr.get(mid) <= target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}

return right;

Goal: Find the largest index where arr.get(right) <= target.

End Condition: Loop exits when left > right. right now points to the last position where arr.get(right) <= target.

Use Case: Use this to find the last occurrence of target or for inserting an element to maintain sorted order just after all instances of target.



---

5. Find Last Position < Target

int left = 0;
int right = arr.size() - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr.get(mid) < target) {
        left = mid + 1;
    } else {
        right = mid - 1;
    }
}

return right;

Goal: Find the largest index where arr.get(right) < target.

End Condition: Loop exits when left > right. right now points to the last position where arr.get(right) < target.

Use Case: Useful when searching for elements strictly less than target, like finding a threshold.



Additional Notes

Lower Bound and Upper Bound: Often used in problems where you want to know where a number could fit into a sorted array, such as when performing range queries or finding nearest elements.

Last Position Variations: Useful when looking for boundaries in sorted data, especially in applications that involve range queries or counting occurrences in data arrays.


Each variation has its own use case depending on whether you need the exact index, first or last occurrence, or the boundary for insertion.
![image](https://github.com/user-attachments/assets/e3297b9e-9400-48d9-aa96-c02f9fa342f5)
