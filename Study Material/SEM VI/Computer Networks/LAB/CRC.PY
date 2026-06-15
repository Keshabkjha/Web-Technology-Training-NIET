class CRC:
    def _init_(self):
        self.cdw = ''
    def xor(self, a, b):
        result = []
        for i in range(1, len(b)):  
            result.append('0' if a[i] == b[i] else '1')  
        return ''.join(result)
    def crc(self, message, key):
        pick = len(key)
        tmp = message[:pick]

        while pick < len(message):
            if tmp[0] == '1':
                tmp = self.xor(key, tmp) + message[pick]
            else:
                tmp = self.xor('0' * pick, tmp) + message[pick]
            pick += 1
        if tmp[0] == "1":
            tmp = self.xor(key, tmp)
        else:
            tmp = self.xor('0' * pick, tmp)
        return tmp  
    def encodedData(self, data, key):
        l_key = len(key)
        append_data = data + '0' * (l_key - 1)
        remainder = self.crc(append_data, key)
        codeword = data + remainder
        self.cdw = codeword  
        print("Remainder:", remainder)
        print("Encoded Data:", codeword)
    def receiverSide(self, key, data):
        remainder = self.crc(data, key)
        size = len(key)
        print("Remainder at Receiver Side:", remainder)
        if remainder == '0' * (size - 1):
            print("No Error Detected")
        else:
            print("Error Detected")
data = input("Enter Data (Binary): ")
key = input("Enter divisor (Binary): ")
print('---------------')
crc_obj = CRC()
crc_obj.encodedData(data, key)
print('---------------')
crc_obj.receiverSide(key, crc_obj.cdw)
print('---------------')
print("Final Codeword:", crc_obj.cdw)