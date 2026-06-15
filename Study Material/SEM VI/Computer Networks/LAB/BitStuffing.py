def bit_stuffing(str):
	stuffed_string = ""
	count = 0
	for bit in str:
		if bit == "1":
			count += 1
		else:
			count = 0
		stuffed_string += bit
		if count == 5:	
			stuffed_string += "0"
			count = 0

	return stuffed_string
def bit_destuffing(stuffed_string):
	destuffed_string = "" 
	count = 0
	i = 0
	while i < len(stuffed_string):
		destuffed_string += stuffed_string[i]
		if stuffed_string[i] == "1":
			count += 1
		else:
			count = 0
		if count == 5:
			i += 1
			count = 0
		i += 1
	return destuffed_string
binary_input = input("Enter the binary string: ") #Keshab kumar
stuffed_output = bit_stuffing(binary_input)
print("Bit Stuffed : ", stuffed_output)
destuffed_string = bit_destuffing(stuffed_output)
print("Bit Destuffed: ", destuffed_string)