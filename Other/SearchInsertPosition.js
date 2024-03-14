/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsertRECURSIVE = function(nums, target) {

  let mid = Math.floor((nums.length)/2);

  if (nums[mid] == target) return mid;
  if (nums.length == 2 && target > nums[1]) return 2;
  else if (mid <= 1) return 1;

  if (nums[mid] > target) return mid - searchInsertRECURSIVE(nums.slice(0, mid), target);
  else if (nums[mid] < target) return mid + searchInsertRECURSIVE(nums.slice(mid), target);
};

console.log(searchInsertRECURSIVE([1, 3, 5, 6], 5)); 		// Return 2
console.log(searchInsertRECURSIVE([1, 3, 5, 6], 2)); 		// Return 1
console.log(searchInsertRECURSIVE([1, 3, 5, 6], 7)); 		// Return 4




var searchInsertLOOP = function(nums, target) {

  let hi = nums.length-1;
  let lo = 0;
  while (hi > lo) {   //  2 3 4 5 6 7   => mid is 4.5 => 7-2/2 + 2 = 4.5 => floor = 4 correct?

    let mid = Math.floor(((hi-lo)/2)+lo); // will be 1 first

    if (nums[mid] == target) return mid;
    if (nums[mid] > target) hi = hi - 1;
    if (nums[mid] < target) lo = lo + 1;

  }
  return lo;
}

console.log(searchInsertRECURSIVE([1, 3, 5, 6], 5));          // Return 2
console.log(searchInsertRECURSIVE([1, 3, 5, 6], 2));          // Return 1
console.log(searchInsertRECURSIVE([1, 3, 5, 6], 7));          // Return 4

