import csv
import sys

def completaIp(s):
    if len(s) < 8:
        for n in range(0,8-len(s)):
            s = "0" + s
    return s

def montaIp(ip):
        octeto1 = ip[0:ip.index(".")]
        octeto1bin = bin(int(octeto1))[2:]
        octeto1bin = completaIp(octeto1bin)

        ip = ip[len(octeto1)+1:]
        
        octeto2 = ip[0:ip.index(".")]
        octeto2bin = bin(int(octeto2))[2:]
        octeto2bin = completaIp(octeto2bin)

        ip = ip[len(octeto2)+1:]

        octeto3 = ip[0:ip.index(".")]
        octeto3bin = bin(int(octeto3))[2:]
        octeto3bin = completaIp(octeto3bin)

        ip = ip[len(octeto3)+1:]
        
        octeto4 = ip
        octeto4bin = bin(int(octeto4))[2:]
        octeto4bin = completaIp(octeto4bin)

        ip = octeto1bin + octeto2bin + octeto3bin + octeto4bin
        return ip

argumentos  = sys.argv
arquivo = argumentos[1]

endereco = argumentos[2]

ips_matches = []
cidr_matches = []
saida_matches = []


ip_endereco = (montaIp(endereco))
with open(arquivo) as csv_file:
    
    csv_reader = csv.reader(csv_file, delimiter=',')

    csv_reader.__next__()

    for row in csv_reader:
        ip = montaIp(row[0])

        cidr = int(row[1])
        if (ip[0:cidr] == ip_endereco[0:cidr]):
            ips_matches.append(ip)
            cidr_matches.append(cidr)
            saida_matches.append(row[2]) 

if len(ips_matches) >= 1:
    maior = cidr_matches.index(max(cidr_matches))
    print('Interface de Saída: ' + saida_matches[maior])
else:
    print('PACOTE PERDIDO! - A tabela de rotas não possui uma saída para esse endereço IP.')
        
# Terminal: pyton .\vp1.py "Caminho para .csv" "Endereço IP"
# Exemplo de uso para o terminal:  python .\vp1.py C:\Users\GOLDENTEC\Documents\dados.csv 192.45.67.55
# OBS: O caminho para o arquivo .csv NÃO pode conter espaços (Ex: C:\Users\GOLDENTEC\Documents\Redes 2\dados.csv)        