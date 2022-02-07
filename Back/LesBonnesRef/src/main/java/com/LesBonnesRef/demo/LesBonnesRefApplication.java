package com.LesBonnesRef.demo;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

//inmport des interface de mes composants
import com.LesBonnesRef.demo.dao.ProduitRepository;
import com.LesBonnesRef.demo.dao.UtilisateurRepository;

//import des entités 
import com.LesBonnesRef.demo.entities.Utilisateur;
import com.LesBonnesRef.demo.entities.Produit;

@SpringBootApplication
public class LesBonnesRefApplication implements CommandLineRunner
{
	@Autowired //permet de récupérer les données produit
	private ProduitRepository produitRepository;
	
	@Autowired //permet de récupérer les données utilisateur
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private RepositoryRestConfiguration restRespository; //connection à l'API rest
	
	public static void main(String[] args) 
	{
		SpringApplication.run(LesBonnesRefApplication.class, args);// lancement de la méthode run
	}
 
	@Override
	public void run(String... args) throws Exception 
	{
		// TODO Auto-generated method stub
		System.out.println("El Backolongo tiene vida");
		
		//chemin de mon ordi 
//        String path = "D:/Système/Users/CHERUB96X/Images/projetImage";
//		
//		//création de mes images
//		BufferedImage img1 = ImageIO.read(new File(path+"/image1.jpg"));
//		
//		BufferedImage img2 = ImageIO.read(new File(path+"/image2.jpg"));
//		
//		BufferedImage img3 = ImageIO.read(new File(path+"image3.jpg"));
//		
//		//création de mon tableau d'image
//		BufferedImage tableauImgProduit[] = new BufferedImage[3];
//		
//		//ajout des images dans le tableau
//		tableauImgProduit[0]=img1;
//		tableauImgProduit[1]=img2;
//		tableauImgProduit[2]=img3;
//		
		
		//création de l'utilisateur 
		Utilisateur user1 = new Utilisateur(null,"Prie","Galaad","067578843","TikitaJeLaLove","PrieGalaad@gmail.com","4 Rue De la BheuRisière","vendeur",4);
		utilisateurRepository.save(user1);
		
		Utilisateur user2= new Utilisateur(null,"Mattei","Olivier","067578843","titi13","olimatt96@gmail.com","4 Rue De la Concorde","admin",5);
		utilisateurRepository.save(user2);
		
		Utilisateur user3= new Utilisateur(null,"Delgado","Luis","0659307155","123456","luisrma7@hotmail.com","33 Henri Malacrida","admin", 5);
		utilisateurRepository.save(user3);

		
		//création d'un produits
//		Produit produit1 = new Produit(null,"Thé Noir","Un thé noir, ou thé anglo-indien, est fait de feuilles de théier qui ont subi une oxydation complète. Ces thés sont nommés thés rouges dans le monde chinois. En Chine, on appelle « thé noir » le thé post-fermenté, comme le pu-erh. ","150","test","MarquageTest","https://st.depositphotos.com/1020804/1945/i/600/depositphotos_19458553-stock-photo-cup-of-tea-and-teapot.jpg",455, user1,tableauImgProduit);
//		produitRepository.save(produit1);
		
		Produit produit2 = new Produit(null,"Deli Lot de Mini Outils de Jardinage","4 Outils de Jardinage Légers, Peu de Piliers Chrome-Molybdène et Poignée Ergonomique Antidérapante ","20","Jardinage","FANHAO","https://m.media-amazon.com/images/I/513EOSpAiNL._AC_SL1001_.jpg",455, user1);
		produitRepository.save(produit2);
		
		Produit produit3 = new Produit(null,"Râteau de désherbage de Jardin","Râteau de jardin à tête coudée avec manche en bois Noir. Taille de la poignée : 12,9 x 2,9 cm/ 5,1 'x 1,1' (H*D) ; Longueur totale : 32,3 cm/ 12,7' ","25","Jardinage","One+","https://m.media-amazon.com/images/I/41mZCD8jgSL._AC_SL1020_.jpg",455, user2);
		produitRepository.save(produit3);
		
		Produit produit4 = new Produit(null,"Coupe-bordures sans fil","Puissant, performant, léger et très confortable à utiliser, ce coupe-bordure OLT1831 de Ryobi dispose d'autres atouts dans sa manche. Il suffit d'acheter une seule station de charge et une batterie unique pour alimenter tous les autres outils","80","Jardinage","One+","https://www.taille-bordure-warrior.com/images/coupe-bordure-batterie-5.jpg",455, user3);
		produitRepository.save(produit4);
		
		Produit produit5 = new Produit(null,"Harry Potter, I à VII","Ce magnifique coffret collector contient les sept volumes de l'édition courante en Folio Junior de la saga Harry Potter, et un cadeau caché à l'intérieur. ","69","Livres","Salamandra","https://images-na.ssl-images-amazon.com/images/I/71rOzy4cyAL.jpg",455, user1);
		produitRepository.save(produit5);
		
		Produit produit6 = new Produit(null,"A Textbook of Java Programming - Surbhi Kakar","Surbhi Kakar propose une présentation très pédagogique d'un langage de programmation, présentation qui peut s'adresser aussi bien à des débutants en Java, qu'à des programmeurs qui connaissent Java mais qui souhaitent un livre de référence.","30","Livres","WILEY","https://www.wileyindia.com/pub/media/catalog/product/cache/b3b166914d87ce343d4dc5ec5117b502/9/7/9789389520910.jpg",455, user2);
		produitRepository.save(produit6);
		
		Produit produit7= new Produit(null,"Manga en Japonais : Shingeki No Kyojin (L'Attaque des Titans) tome 1 à 23","Tome 1 à 23 du manga Shingeki No Kyojin \"L'Attaque des Titans\" en édition originale (langue) japonaise. Occasion, très bon état. Négociation possible.","69","Livres","ShônenJump","https://www.manga-occasion.com/images/annonces/119574/119574-2.jpg",455, user3);
		produitRepository.save(produit7);
		
		Produit produit8 = new Produit(null,"Ballon de football M SAL5X5","Top:White/Active Scarlet Red Bottom:Bright Orange/Solar Gold/Black, FR Unique (Taille Fabricant : FUTS)","10","Sport","MOLTEN","https://www.journaldugeek.com/content/uploads/2020/11/football-1396740-1920.jpg",455, user1);
		produitRepository.save(produit8);
		
		Produit produit9 = new Produit(null,"Rameurs d'appartement CAPITAL SPORTS Stream M1","Rameur Professionnel : entraînement très Efficace, résistance magnétique à 8 Niveaux, Rail en Aluminium de 105 cm","300","Sport","Capital Sports","https://m.media-amazon.com/images/I/512mtGQ4dZS._AC_SL1500_.jpg",455, user2);
		produitRepository.save(produit9);
		
		Produit produit10 = new Produit(null,"Appareils de Fitness 5 en 1","Roue Abdominale + Poignée de Pompe + Corde à Sauter + Pince à Main + Tapis pour Genou Kit Complet pour Fitness Exercices Musculation","40","Sport","TOMSHOO","https://m.media-amazon.com/images/I/6193XG1p1kL._AC_SL1000_.jpg",455, user3);
		produitRepository.save(produit10);
		
		Produit produit11 = new Produit(null,"Guitare Folk Yamaha","YAMAHA la F370 Black possède une table en épicéa et 21 Frettes, cette Guitare Yamaha est l'une des plus réussies de sa catégorie.","150","Musique","YAMAHA","https://rukminim1.flixcart.com/image/416/416/j7gi6q80/acoustic-guitar/m/z/c/f310nt-yamaha-original-imaewzgzsn2warez.jpeg?q=70",455, user1);
		produitRepository.save(produit11);
		
		Produit produit12 = new Produit(null,"Vinyle AC/DC Back in Black","Après la mort de Bon Scott, les Australiens rebranchent les Gibson avec panache. Pour le bonheur de nos tympans, la batterie tape et la voix est toujours au top avec le petit nouveau, Brian Johnson.","21","Musique","Epic","https://m.media-amazon.com/images/I/51OnwdPjLML._SL1175_.jpg",455, user2);
		produitRepository.save(produit12);
		
		Produit produit13 = new Produit(null,"Clavier Professional MPK Mini MK3","Clavier Maître USB MIDI 25 Touches avec 8 pads Rétroéclairés, la 3e itération du légendaire clavier maître USB MIDI avec 25 minitouches et le plug-and-play qui a redéfini la façon de créer de la musique pour toute une génération.","300","Musique","AKAI Professional","https://m.media-amazon.com/images/I/717qmGlA7ZL._AC_SL1500_.jpg",455, user3);
		produitRepository.save(produit13);
		
		Produit produit14 = new Produit(null,"Tommy Hilfiger Hoodie Ls Sweat-Shirt Femme Rouge","Ces pièces indispensables revisitées présentent un esprit sobre et des lignes intemporelles. Elles sont parfaites pour composer sans effort des tenues dans l'air du temps.","120","Vetements","Tommy Hilfiger","https://image-cdn.hypb.st/https%3A%2F%2Fhypebeast.com%2Fwp-content%2Fblogs.dir%2F6%2Ffiles%2F2018%2F01%2Fvetements-tommy-hilfiger-double-sleeve-hoodie-red-0.jpg?w=960&cbr=1&q=90&fit=max",455, user1);
		produitRepository.save(produit14);
		
		Produit produit15 = new Produit(null,"Boot Timberland Splitrock 2 TB0A2KBR763","Dessus: Simili cuir, doublure: Textile, matériau de semelle: Caoutchouc synthétique, hauteur de la tige : cheville, largeur de la chaussure: Normal, fermeture: Lacet","130","Vetements","Timberland","https://img-4.linternaute.com/NkiNmgZit4Qnk8APSNEXeUuDE4E=/1500x/smart/5b49e951b67d45e6a3fc5b9801d9765e/ccmcms-linternaute/10668269.jpg",455, user1);
		produitRepository.save(produit15);
		
		Produit produit16 = new Produit(null,"Chaussettes mi-mollet Nike Sportswear","Technologie Dri-FIT pour garder vos pieds au sec et à l'aise, le talon et la pointe renforcés offrent une plus grande durabilité, le mesh placé aux endroits stratégiques apporte une meilleure respirabilité.","23","Vetements","Nike","https://media.alltricks.com/hd/17823025f4781b2e3b318.90312780.jpg",455, user2);
		produitRepository.save(produit16);
		
		Produit produit17= new Produit(null,"Lot de 2 Table de Chevet, Bomcosy Table de Nuit Bois","Style Industrielle, Empilable, Compartiment de Rangement Ouvert, Pieds en Acier, Style Industriel, Marron Rustique et Noir. Dimensions du produit	35D x 42W x 52H centimètres","83","Domestique","Bomcosy","https://m.media-amazon.com/images/I/719PwPpNhOL._AC_SL1500_.jpg",455, user3);
		produitRepository.save(produit17);
		
		Produit produit18= new Produit(null,"Canapé d'angle convertible et réversible avec Coffre","Canapé moderne convertible avec coffre de rangement - Angle réversible (droite/gauche) - Coloris simili blanc (PU) / tissu gris (100% polyester). Longueur totale: 255 cm / Prodondeur totale: 165 cm / Hauteur dossier 84 cm - 2 poufs tissu gris inclus 36 x 36 x 40 cm","639","Domestique","Simon","https://m.media-amazon.com/images/I/71RO7tmKlLL._AC_SL1500_.jpg",455, user1);
		produitRepository.save(produit18);
		
		Produit produit19= new Produit(null,"Batterie de cuisine anti-adhésive 15 pièces","La batterie de cuisine anti-adhésive 15 pièces comprend une poêle à frire de 20 cm, un poêle à frire de 25 cm, une casserole de 1,41 l avec couvercle, un fait-tout de 2,83 l avec couvercle, un fait-tout de 4,73 l avec couvercle et un lot de 5 ustensiles avec cuillère à pâtes","49","Domestique","Amazon Basics","https://m.media-amazon.com/images/I/61x-NhdKBmL._AC_SL1500_.jpg",455, user2);
		produitRepository.save(produit19);

		Produit produit20= new Produit(null,"Nintendo Switch avec paire de Joy-Con Rouge Néon et Bleu Néon","Console Nintendo Switch Neon, 1 console avec 1 manette Joy-con droite rouge néon et 1 manette Joy-con gauche bleu néon, 1 station d'accueil Nintendo Switch, 2 dragonnes Joy-con, 1 support Joy-Con","266","JeuxVideo, Electronique","Nintendo","https://m.media-amazon.com/images/I/71N0qlJwsWL._AC_SL1500_.jpg",455, user3);
		produitRepository.save(produit20);
		
		Produit produit21= new Produit(null,"The Witcher 3 : Wild Hunt - édition jeu de l'année","Dans la peau d'un tueur de monstres, The Witcher 3: Wild Hunt est un RPG en monde ouvert, dans un univers fantasy hautement scénarisé aux graphismes époustouflants où chacun de vos choix est décisif.","27","JeuxVideo","CD ProjekT RED","https://image.api.playstation.com/vulcan/img/rnd/202009/3008/bcUoQYjNbyF7kCFaWMaxxdtL.jpg",455, user1);
		produitRepository.save(produit21);
		
		Produit produit22= new Produit(null,"Manette pour Xbox – Noire","Manette de jeu vidéo ergonomique avec disposition standard des boutons, y compris un nouveau bouton Partager","50","JeuxVideo, Electronique","Microsoft Xbox","https://m.media-amazon.com/images/I/41LO2OX6pRL._AC_.jpg",455, user1);
		produitRepository.save(produit22);
		
		Produit produit23= new Produit(null,"GeForce RTX 3090 Trinity OC 24Go","Cœurs de traçage de rayons de 2e génération Cœurs de détection de 3e génération Éclairage RVB SPECTRA 2.0 Refroidissement avancé IceStorm 2.0 Contrôle actif du refroidisseur avec arrêt de ventilateur FREEZE","2790","Electronique","ZOTAC","https://h3v2h5f6.rocketcdn.me/wp-content/uploads/2021/11/nvidia-rtx-3090-ti-puce-micron.jpg",455, user2);
		produitRepository.save(produit23);
		
		Produit produit24= new Produit(null,"Lenovo Legion 5i 15IMH05H PC Portable Gaming 15.6'' Full HD Noir","Intel Core i5, RAM 8Go, SSD 512Go, NVIDIA GeForce GTX 1660 Ti, Écran Full HD de 15,6 pouces (1 920 x 1 080) Windows 10 Famille - Clavier AZERTY","1360","Electronique","Lenovo","https://p1-ofp.static.pub/fes/cms/2021/07/16/gcrmbce4tya30fui8wc3v0pq0w26f0667603.png",455, user3);
		produitRepository.save(produit24);
		
		Produit produit25= new Produit(null,"Souris gamer Logitech G502 Hero High Performance","Gamer - Capteur : Optique Filaire - Ambidextre Sensibilité max : 25600 DPI","69","Electronique","LOGITHECH","https://boulanger.scene7.com/is/image/Boulanger/5099206080270_h_f_l_0?id=nCmoh1&fmt=jpg&dpr=off&fit=constrain,1&wid=535&hei=308",455, user2);
		produitRepository.save(produit25);
		
		Produit produit26= new Produit(null,"Cisaille haie lame droite 26cm + manche bois","Dimensions produit (L x l x H (cm)) : 53 x 20 x 5, Poids unitaire UC nu (Kg) : 1 Kg, Poids unitaire UC avec emballage (Kg) : 1 Kg","69","Domestique","REVEX","https://boutique.revex.fr/media/cache/sylius_shop_product_original/product_images/153160_N1_2014.jpg",455, user3);
		produitRepository.save(produit26);
		
		Produit produit27= new Produit(null,"Couvre-lit en lin lavé terracotta doublure en percale de coton lavé Oslo Passage Vernet","Ce couvre-lit bi-faces en lin et percale de coton lavés sera l´atout déco dans votre chambre. Au recto, un lin lavé doux, au tombé souple, associé à une couleur terracotta très actuelle. Au verso, une percale de coton ultra douce dans la même teinte.","152","Domestique","REVEX","https://cdn0.decoclico.fr/135540/960x665/couvre-lit-en-lin-lave-terracotta-doublure-en-percale-de-coton-lave-oslo-passage-vernet.jpg",455, user1);
		produitRepository.save(produit27);
		
		Produit produit28= new Produit(null,"Casque audio sans fil Bose QuietComfort 35 II","Le nouvelle génération de ce modèle à succès cumule tous les atouts de son aîné en y ajoutant un bouton de commande. Confortable, bien construit et très simple à utiliser, il délivre un son clair, notamment sur les voix, en privilégiant les basses.","60","Musique, Electronique","Bose","https://www.beyeah.net/wp-content/uploads/2016/10/Sennheiser-Momentum-2-0-casque-filaire.jpg",455, user2);
		produitRepository.save(produit28);
		
		





		
		
		
		
		restRespository.exposeIdsFor(Produit.class); //permet la récupération du champ id
		
	}

}
