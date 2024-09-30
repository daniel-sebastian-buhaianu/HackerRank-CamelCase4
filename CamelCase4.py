import sys

def camel_case(line):
    operation = line[0]
    format_type = line[2]
    text = line[4:]

    if operation == 'S':
        result = ''.join(f' {char.lower()}' if char.isupper() else char for char in text)
        # Remove '()' if it's a method
        if format_type == 'M':
            result = result[:-2]
        
        print(result.strip())

    else:
        words = text.split()
        
        if format_type == 'C':
            result = ''.join(word.capitalize() for word in words)
        else:
            result = words[0].lower() + ''.join(word.capitalize() for word in words[1:])
            # Add '()' if it's a method
            if format_type == 'M':
                result += '()'
                
        print(result)

if __name__ == '__main__':
    # Read line by line
    for line in sys.stdin:
        # Remove any trailing whitespace or newline
        line = line.strip()
        # Apply the string conversion
        camel_case(line)
