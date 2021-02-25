#include <iostream>
#include <fstream>
#include <string>
#include <sstream>

using namespace std;

class ExceptieEmail {
public:
	string mesaj;
	int codEroare;

	ExceptieEmail(string msj, int cod) {
		this->mesaj = msj;
		this->codEroare = cod;
	}
};

class Email {
	
	string subject = "";
	
	string *to = NULL;
	int nrAdrese = 0;
	bool *confirmari = NULL;
	char* continut = nullptr;
	char from[100] = "";
public:
	
	const int id;
	Email() :id(0){

	}

	Email(int id, string subiect) :id(id) {
		this->subject = subiect;
	}

	~Email()
	{
		//Modificare 7: Verificare daca exista inainte de stergere
		delete[] to;
		delete[] confirmari;
		delete[] continut;

	}

	Email(int id, string subject, const char* from, string *to, int nrAdrese, bool *confirmari, const char* continut) :id(id) {

		this->subject = subject;

		strcpy(this->from, from);

		this->to = new string[nrAdrese];
		for (int i = 0; i < nrAdrese; i++)
			this->to[i] = to[i];

		this->nrAdrese = nrAdrese;

		this->confirmari = new bool[nrAdrese];
		for (int i = 0; i < nrAdrese; i++)
			this->confirmari[i] = confirmari[i];

		this->continut = new char[strlen(continut) + 1];
		strcpy(this->continut, continut);
	}

	Email(int id, string subject, const char* from, string *to, int nrAdrese, bool *confirmari) :id(id) {
		this->subject = subject;

		strcpy(this->from, from);

		this->to = new string[nrAdrese];
		for (int i = 0; i < nrAdrese; i++)
			this->to[i] = to[i];

		this->nrAdrese = nrAdrese;

		this->confirmari = new bool[nrAdrese];
		for (int i = 0; i < nrAdrese; i++)
			this->confirmari[i] = confirmari[i];
	}

	Email(Email& e):id(e.id) {
	this->subject = e.subject;

	strcpy(this->from, e.from);

	if (this->to != NULL) {

		delete[] this->to;
		
	}
	this->to = new string[e.nrAdrese];
	for (int i = 0; i < e.nrAdrese; i++)
		this->to[i] = e.to[i];

	this->nrAdrese = e.nrAdrese;

	if (this->confirmari != NULL) {

		delete[] this->confirmari;
		
	}
	this->confirmari = new bool[nrAdrese];
	for (int i = 0; i < nrAdrese; i++)
		this->confirmari[i] = e.confirmari[i];

	if (this->continut != NULL) {

		delete[] this->continut;
		this->continut = new char[strlen(e.continut) + 1];
		strcpy(this->continut, e.continut);
	}

	}

	Email& operator=(Email e) {
		this->subject = e.subject;

		strcpy(this->from, e.from);

		if (this->to != NULL) {

			delete[] this->to;
			
		}
		this->to = new string[e.nrAdrese];
		for (int i = 0; i < e.nrAdrese; i++)
			this->to[i] = e.to[i];

		this->nrAdrese = e.nrAdrese;
		
		if (this->confirmari != NULL) {

			delete[] this->confirmari;
			
		}
		this->confirmari = new bool[nrAdrese];
		for (int i = 0; i < nrAdrese; i++)
			this->confirmari[i] = e.confirmari[i];

		if (this->continut != NULL) {

			delete[] this->continut;
			this->continut = new char[strlen(e.continut) + 1];
			strcpy(this->continut, e.continut);
		}

		return *this;
	}

	void print() {

		//Modificare 6: Utilizare operator this pentru nrAdrese, to pentru o mai buna intelegere
		cout << "\n----------------------\n";
		cout << "Id: " << id<<endl;
		cout << "Subiect : " << subject<<endl;
		cout << "From: " << from<<endl;
		if (nrAdrese != 0) {
			if(to!=NULL)
			cout << "To: ";
				for (int i = 0; i < nrAdrese; i++)
					cout << to[i] << " | ";
			cout << "\nCOnfirmari: ";
				for (int i = 0; i < nrAdrese; i++)
					cout << confirmari[i] << " | ";
		}
		if(continut!=NULL)
		cout << "\nBody: " << continut;
	}

	void setFrom(const char* from) {
		
		strcpy(this->from, from);
	}

	//Moficare 2: Variabila em redenumita in emailNou
	void addEmail(string em) {

		//Modificare 6: Utilizare operator this pentru nrAdrese, to pentru o mai buna intelegere
		string *aux;
		aux = new string[nrAdrese];
		for (int i = 0; i < nrAdrese; i++)
			aux[i] = to[i];
		delete[] this->to;
		
		this->to = new string[nrAdrese + 1];
		for (int i = 0; i < nrAdrese; i++)
			to[i] = aux[i];
		this->to[nrAdrese] = em;
		nrAdrese++;
		delete[] aux;

	}
	
	friend ostream& operator<<(ostream& out, Email& e);
	
};

ostream& operator<<(ostream& out, Email& e) {

	out << "\n______________________________________________________________________________________\n";
	out << "Email " << e.id << " from " << e.from;
	if (e.nrAdrese != 0)
		out << " to ";
	for (int i = 0; i < e.nrAdrese; i++)
		out << e.to[i] << "; ";
	out << endl;

	int ok = 1;
	out << "Confirmari de la: ";
	for (int i = 0; i < e.nrAdrese; i++)
		if (e.confirmari[i] == 1) {
			out << e.to[i] << "; ";
			ok = 0;
		}
	if (ok == 1)
		out << "*nimeni*";
	out << endl << "Subject: " << e.subject << endl;
	out << "Continut:" << endl;
	if (e.continut != NULL)
		out << e.continut;
	return out;

	
}

int main() {

	string* to = new string[1];
	to[0] = "vic";
	bool* conf=new bool[1];
	conf[0] = 1;
	
	//Modificare 4: O initializare mai decenta
	string Sub = "HelloHolaBuna";
	int id = 1;
	char from[50];
	
	//Modificare 5: Inlocuire hardcodare "Hey" cu o variabila in caz ca ar exista reutilizari pe viitor
	strcpy(from, "Hey");
	
	//Modificare 8: Spargerea liniei urmatoare in 2 linii pentru o mai buna citire
	char* continut = new char[strlen("hello")+1];strcpy(continut, "hello");
	
	Email e1(id, Sub, from, to, 1, conf, "hello");

	Email e2(id, Sub);
	e2 = e1;

	e1.addEmail("Maria.dragomir");
	
	//Modificare 1: Stergere comentarii
	//cout << e1;
	

	Email e3(id, Sub, from, to,1, conf);

	Email e4 = e3;

	//Modificare 3: Redenumire llistaEmail in listaEmail (typo de scriere)
	Email* llistaEmail[4];
	
	llistaEmail[0] = &e1;
	llistaEmail[1] = &e2;
	llistaEmail[2] = &e3;
	llistaEmail[3] = &e4;



	ofstream raport;
	raport.open("Email1.txt", ios::out | ios::trunc);
	for(int i=0;i<4;i++)
	raport << (*llistaEmail[i]);
	raport.close();

	//Modificare 3: Redenumire listaFisier in listaEmailTXT
	Email* listaFisier[100];
	ifstream input("Email.txt");
	int i = 0;
	if (!input.is_open())
		cout << "Fisier nedeschis";
	else
	{
		while (!input.eof()) {
			string linieFisier;
			char buffer[1000];
			input.getline(buffer, 1000);
			linieFisier = string(buffer);
			if (linieFisier.find("-") == -1) {

				//Modificare 1: Stergere comentarii
				//cout << linieFisier << endl;
				Email aux;

				if (linieFisier.find("from") != -1) {
					int indexFrom = linieFisier.find("from") + 5;

					string fromm = linieFisier.substr(indexFrom,
						linieFisier.find("to") - indexFrom - 1);
					aux.setFrom(fromm.c_str());
					linieFisier = linieFisier.substr(linieFisier.find("to"),
						linieFisier.length() - linieFisier.find("to"));
					

				}
				//Modificare 1: Stergere comentarii
				
				/*cout << linieFisier;
				for (int indexI = 0; indexI < linieFisier.length(); indexI++)
					if (linieFisier[indexI] == 't' && linieFisier[indexI] == 'o')
						cout << indexI;*/

				if (linieFisier.find("to")!=-1) {
					
					//Modificare 1: Stergere comentarii
					//cout << linieFisier;
					while (linieFisier.find("com") != -1) {
						int indexTo = 3;
						string too = linieFisier.substr(indexTo+1, linieFisier.find(";") - indexTo);
						cout << too << endl;
						aux.addEmail(too);
						too = linieFisier.substr(linieFisier.find(";") - 2, too.length() - linieFisier.find(";") - 2);
						linieFisier= linieFisier.substr(linieFisier.find(";") - 2, too.length() - linieFisier.find(";") - 2);
						
						//Modificare 1: Stergere comentarii
						//cout << too.substr(linieFisier.find(";") - 2, too.length() - linieFisier.find(";") - 2);
					}
					
					//Modificare 1: Stergere comentarii
					/*int IndexTo = linieFisier.find_first_of(".c") + 5;
					string too = linieFisier.substr(IndexTo
						, linieFisier.find(";") - IndexTo);*/

					//cout << too;
					//cout<<too.substr(too.find(";"), too.find(";"));
					
				}
				
				i++;
			}
			//Modificare 1: Stergere comentarii
			//cout << endl;
			
		}
		input.close();
	}

	
	


}