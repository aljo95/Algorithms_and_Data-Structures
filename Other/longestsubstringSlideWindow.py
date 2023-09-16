from collections import Counter


# Counter is a subclass of dict. Designed for counting hashable objects.
# It's a dict that stores objects as KEYS and counts as VALUES.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        chars = Counter()  # chars is an object of Counter class now
        # Counter counts every char and how many of them
        left = right = 0

        result = 0
        while right < len(s):
            r = s[right]  # right=0 -> r = a
            chars[r] += 1  # 0 -> 1, "aba" when right=2 chars[r] will be = 2

            # when identical char added to r, chars[r] += 1 will become 2 and enter next loop

            while chars[r] > 1:     # while x > 1 means LOOP FOREVER! 1 = True
                l = s[left]
                chars[l] -= 1       # from 2 -> 1, because "a" exists twice in chars
                left += 1           # and chars[l]'s value = chars[r]=1 now, exit while

            result = max(result, right - left + 1)
            right += 1
        return result


string = "aba"
ob = Solution()
print(ob.lengthOfLongestSubstring(string))
print("\n")


# TESTS #

riight = leeft = 0
chars2 = Counter()

rr = string[riight]
print(rr)
print(chars2[rr])  # 0
chars2[rr] += 1
print(chars2[rr])  # 1, now because += 1
riight += 1
rr = string[riight]
print(chars2[rr])  # 0 again because new value "b"
chars2[rr] += 1
print(chars2[rr])  # and made inte 1 because increment

# print(chars2["a"]) # = 1 because a exists once in there
# print(chars2["b"]) # = 0
