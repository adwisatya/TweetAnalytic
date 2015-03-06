/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
/**
 *
 * @author adwisatya
 */
public class StringMatcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Masukkan text:");
    	String text = in.nextLine();
    	cekRegex(text);
    	in.close();
    }
    
    //Cek apakah terdapat daerah pada string dengan menggunakan regex
    public static String cekRegex(String masukan){
    	String out = "";
    	String [] arrOfPattern	= {"([A|a][B|b][C|c]|[N|n]eglasari|[A|a]yudia|[A|a]ksan|[A|a]lani|[A|a]lun-alun [T|t]imur|[J|j]akin|[A|a]mbon|[K|k]arangarum|[N|n]anas|[A|a]ngandara|[S|s]irnagalih|[T|t]asikmalaya|[A|a]rjuna|[A|a]stanaanyar|[A|a]stina|[B|b]engkel|[A|a]ceh|[B|b]abakan [C|c]iamis|[B|b]abatan|[B|b]ali|[B|b]alonggede|[B|b]anda|[M|m]ohamad [T|t]oha|[B|b]angka|[B|b]anceuy|[B|b]arata|[C|c]endana|[B|b]aros|[B|b]awean|[B|b]adaksinga|[D|d]ipati [U|u]kur|[B|b]engawan|[C|c]iumbulleuit|[C|c]iungwanara|[H|h]sssanudin|[R|r]anggamalela|[B|b]elitung|[B|b]lanak|[B|b]limbing|[B|b]uahbatu|[B|b]ukit [J|j]arian|[B|b]ukit [T|t]unggul|[B|b]ungur|[B|b]ungsu|[B|b]urangrang|[A|a]ceh|[D|d]okter [S|s]utomo|[B|b]orneo|[S|s]uria [K|k]ancana|[P|p]anumbangjaya|[R|r]anggagading|[S|s]oka|[T|t]arate|[K|k]idang [P|p]ananjung|[G|g]eusanulun|[B|b]raga|[B|b]rantas|[J|j]atayu|[S|s]ukajadi|[M|m]arconi|[H|h]egarmanah [W|w]etan|[H|h]egarmanah [K|k]ulon|[P|p]ajajaran|[P|p]urnawarman|[D|d]okter [W|w]ahidin|[K|k]embang [T|t]anjung|[C|c]ulan|[K|k]arangtineung|[K|k]embang [D|d]ayang|[S|s]ukawangi|[S|s]ulawesi|[S|s]eram|[P|p]ecinan [L|l]ama|[M|m]alabar|[K|k]eristelek|[K|k]olektor|[[F|f]|e]rguloh|[K|k]ejaksaan|[C|c]urie|[S|s]awunggaling|[J|j]akarta|[D|d]ago/[J|j][I|i][I|i]r [H|h]aji [J|j]uanda|[D|d]ahlia|[D|d]alem [K|k]aum|[P|p]abrik [D|d]aging|[S|s]ukajadi|[C|c]imandiri|[D|d]asarata|[D|d]ederuk|[K|k]arangsari|[H|h]egarmanah|[V|v]an [D|d]eventer|[R|r]aden [D|d]ewi|[K|k]embang [S|s]epatu|[J|j]ambal|[J|j]apati|[J|j]eruk|[J|j]ohar|[D|d]ukuh|[D|d]ursasana|[D|d]orna|[[F|f]|e]hrlich|[W|w]astukancana|[C|c]ikutra|[P|p]rof [[F|f]|e]yckman|[I|i]ndustri|[H|h]aji [W|w]asyid|[P|p]ajajaran|[S|s]irnasari|Flores|[G|g]aruda|[S|s]ultan [T|t]irtayasa|[G|g]abus|[L|l]amping|[G|g]alunggung|[S|s]irnamanah|[G|g]ardujati|[B|b]ahureksa|[T|t]aman [S|s]ari|[G|g]unung [A|a]gung|[G|g]unung [K|k]areumbi|[G|g]unung [P|p]utri|[G|g]untur|[L|l]ebak|[K|k]aranglayung|[G|g]ajahiumantung|[S|s]iliwangi|[D|d]okter [S|s]ukimin|[L|l]inggawastu|[P|p]a [J|j]iping|[H|h]alimun|[H|h]almahera|[K|k]iayi [G|g]ede [U|u]tama|[T|t]ubagus [I|i]smail|[H|h]ata|[J|j]amuju|[S|s]ultan [A|a]gung|[L|l]amping|[D|d]okter [R|r]ajiman|[M|m]enjangan|[S|s]erang|[T|t]engku [A|a]ngkasa|[S|s]omawinata|[A|a]bdurachman [S|s]aleh|[B|b]agusrangin|[W|w]ira [A|a]ngun-angun|[H|h]egarmanah|[D|d]okter [S|s]usilo|[G|g]aneca|[P|p]angeran [K|k]ornel|[H|h]otel [H|h]oman|[T|t]aman [S|s]ari|[L|l]apangan [C|c]iujung|[C|c]lujung|[S|s]uren|[S|s]umur [B|b]andung|[T|t]aman [S|s]ari|[S|s]ukabumi|[T|t]aman [N|n]usantara/[T|t]m[L|l]alu [L|l]intas|[S|s]urapati|[L|l]apangan [J|j]ap [L|l]un|[J|j]ap [L|l]un|[J|j]awa|[J|j]un [L|l]iong|[A|a]ryajipang|[J|j]o [S|s]un [B|b]ie|[T|t]aman [S|s]ari|[K|k]iputih|[S|s]urapati|[K|k]alih [A|a]po|[K|k]amuning|[C|c]isanggarung|[C|c]ihapit|[A|a]ceh|[K|k]enari|[K|k]apatihan|[K|k]arapitan|[K|k]artini|[K|k]ebonjati|[K|k]ebon [J|j]ukut|[S|s]etasion [T|t]imur|[K|k]ebon [K|k]awung|[M|m]ohamad [T|t]oha [B|b]anjaran|[K|k]ebon [S|s]irih|[A|a] c e h|[K|k]ebon [W|w]aru [T|t]engah|[K|k]ebon [W|w]aru [U|u]tara|[L|l]apangan [K|k]ebon [W|w]aru|[K|k]ebon [W|w]aru [S|s]elatan|[K|k]ejaksaan|[K|k]encana|[G|g]ereja|[K|k]elenteng|[K|k]arangtingal|[C|c]isangkuy|[C|c]ilaki|[K|k]iaracondong|[K|k]ihiur|[P|p]ajajaran|[T|t]engku [A|a]ngkasa|[M|m]undinglaya|[H|h]aji [A|a]kbar|[K|k]opo|[K|k]orawa|[K|k]osambi|[R|r]akata|[K|k]resna|[D|d]ayang [S|s]umbi|[B|b]egawan [S|s]empani|[L|l]ayang|[L|l]aksana|[S|s]angkuriang|[B|b]abakan [C|c]iamis|[P|p]erintis [K|k]emerdekaan|[N|n]ijiand|[C|c]ihampelas|[L|l]empuk|[L|l]engkong [B|b]esar|[L|l]engkong [K|k]ecil|[L|l]esmana|[R|r]angga [G|g]empol|[L|l]apangan [B|b]engawan|[M|m]arjuk|[H|h]aji [M|m]oh [I|i]skat|[W|w]astukancana|[L|l]ombok|[S|s]etasion [S|s]elatan|[G|g]ambir|[G|g]elapnyawang|[M|m]adura|[A|a]dipati [K|k]ertabumi|[G|g]udang [U|u]tara|[G|g]udang [S|s]elatan|[S|s]ukaresmi|[M|m]alabar|[M|m]alabar|[M|m]alabar|[S|s]angkuning|[M|m]angga|[M|m]anglit|[L|l]apangan [C|c]irebon|[C|c]irebon|[M|m]ataramatrako|[P|p]atrakomala|[S|s]itu|[A|a]nggrek|[A|a]ceh|[M|m]erak|[P|p]ajajaran|[M|m]erdeka|[T|t]amblong [D|d]alam|[M|m]och [Y|y]unus|[T|t]aman [M|m]aluku|[G|g]arut|[R|r]aden [P|p]atah|[B|b]ogor|[S|s]ulanjana|[N|n]akula|[N|n]angka|[N|n]aripan|[N|n]aripan [D|d]alam|[G|g]andapura|[C|c]ipunagara|[N|n]ias|[K|k]aca-kaca [W|w]etan|[K|k]satriyan|[C|c]iwulan|[C|c]ipaganti|[T|t]ongkeng|[P|p]anaitan|[S|s]unda|[L|l]apangan [D|d]ipati [U|u]kur|[T|t]aman [A|a]nggrek|[A|a]nggrek|[K|k]iayi [L|l]uhur|[L|l]embong|[B|b]ungsu|[P|p]agarsih|[S|s]ukaasih|[P|p]andu|[O|o]tto [I|i]skandardinata [T|t]egallega|[G|g]atot [S|s]ubroto|[T|t]aman [M|m]erdeka|[T|t]aman [S|s]ari|[P|p]asang|[O|o]tto [I|i]skandardinata[P|p]s[B|b]aru|[B|b]elakang [P|p]asar|[P|p]asar [U|u]tara|[P|p]asar [B|b]arat|[P|p]asar [S|s]elatan|[P|p]asirkaliki|[P|p]asirkoja|[P|p]asundan|[P|p]asundan|[P|p]asteur|[P|p]atuha|[P|p]eda|[P|p]ejagalan|[I|i]mam [B|b]onjol|[T|t]aman [P|p]endawa|[P|p]endawa|[P|p]epetek|[L|l]engkong [D|d]alam|[P|p]ujuh|[P|p]ulolaut|[P|p]ungkur|[P|p]urabaya|[P|p]uter|[P|p]utri|[A|a]hmad [Y|y]ani|[J|j]enderal [S|s]udirman|[D|d]okter [R|r]um|[S|s]ingaperbangsa|[C|c]ianjur|[P|p]rogo|[L|l]apangan [P|p]acuan [K|k]uda|[H|h]adi [S|s]ucipto|[K|k]apten [S|s]umantri|[S|s]umedang|[R|r]ama|[R|r]ambutan|[R|r]ancabentang|[R|r]asamala|[J|j]urang|[S|s]amoja|[K|k]abupaten|[D|d]iponegoro|[P|p]asar [B|b]aru|[P|p]acar|[D|d]ipati [U|u]kur|[R|r]iau|[K|k]aca [P|p]iring|[B|b]anda|[D|d]okter [C|c]ipto|[R|r]ontgen|[R|r]iau|[L|l]apangan [D|d]okter [O|o]tten|[H|h]aji [M|m]oh [M|m]esri|[P|p]rabu [D|d]imuntur|[B|b]osscha|[S|s]alam|[L|l]apangan [S|s]abang|[S|s]abang|[S|s]adewa|[S|s]alak|[D|d]okter [S|s]aleh|[S|s]amiaji|[D|d]okter [S|s]amyudo|[S|s]aninten|[S|s]aparua|[S|s]atrugna|[S|s]awo|[M|m]erdeka|[S|s]indangsirna|[S|s]emar|[S|s]epat|[P|p]udak|[R|r]iau|[S|s]impang|[S|s]inta|[A|a]rjuna|[D|d]okter [S|s]lamet|[P|p]atrakomala|[S|s]ukapakir|[S|s]umbadra|[S|s]umbawa|[S|s]unda|[S|s]uniaraja|[S|s]uwatama|[L|l]apangan [P|p]anglayungan|[M|m]orse|[C|c]enteh|[S|s]etasion [T|t]imur|[S|s]etasion [B|b]arat|[S|s]rikandi|[K|k]embang [S|s]epatu|[[F|f]|e]rmawar|[S|s]umarsana|[A|a]stanaanyar|[R|r] [P|p]agergunung|[S|s]umatra|[T|t]aman [M|m]erdeka|[T|t]amblong|[T|t]ampomas|[T|t]anjan|[T|t]anjung|[T|t]anjunganom|[C|c]ilaki|[C|c]iateul|[M|m]oh [T|t]oha|[O|o]tto [I|i]skandardinata|[T|t]egallega|[T|t]ilpon|[T|t]egallega|[T|t]elukbuyung|[T|t]aman [K|k]hewan|[T|t]eri|[T|t]ernate|[T|t]errasana|[D|d]okter [R|r]ubini|[T|t]ikukur|[B|b]anda|[D|d]okter [A|a]bdul [R|r]ivai|[T|t]itiran|[C|c]akranegara|[T|t]aman [C|c]ampaka|[C|c]emara|[C|c]iateul|[C|c]ibadak|[T|t]aman [C|c]ibeunying [U|u]tara|[T|t]aman [C|c]ibeunying [S|s]elatan|[C|c]ibeunying|[C|c]ibuni|[C|c]ibunut [D|d]alam|[T|t]aman [C|c]ibunut|[B|b]uton|[C|c]ihapit|[C|c]ikapayang|[C|c]ikapundung [T|t]imur|[C|c]ikapundung [B|b]arat|[C|c]ikuray|[I|i]mam [B|b]onjol|[C|c]ilaki|[C|c]ilentah|[C|c]iliwung|[C|c]imanuk|[C|c]ipaera|[S|s]astra|[C|c]iremay|[C|c]isangkuy|[T|t]aman [C|c]itarum|[C|c]itarum|[C|c]icendo|[C|c]itrayuda|[C|c]umi-cumi|[B|b]apa [H|h]usen|[L|l]engkong [T|t]engah|[R|r]ais|Fanatayuda|[L|l]engkong [D|d]alam|[H|h]aji [H|h]assan|[M|m]ultatuli|[H|h]ariangbanga|[D|d]okter [G|g]unawan|[K|k]olam|[W|w]ayang|[A|a]runa|[W|w]aringin|[L|l]apangan [W|w]aringin|[T|t]runojoyo|[W|w]esthoff|[S|s]uriani|[W|w]ibisana|[C|c]ilamaya|[D|d]iponegoro|[L|l]apangan [D|d]iponegoro|[W|w]indu|[S|s]rigading|[B|b]anten|[K|k]rawang|[T|t]era|[T|t]aman [G|g]aneca|[P|p]elana|[M|m]aulana [Y|y]usuf|[R|r]umah [S|s]akit|[T|t]engku [U|u]mar|[A|a]ncol|[P|p]ungkur|[B|b]alonggede|[C|c]iseureuh|[C|c]iateul|[P|p]asirluyu|[K|k]arasak|[N|n]yengseret|[K|k]arang [A|a]nyar|[P|p]anjunan|[C|c]ibadak|[P|p]elindung [H|h]ewan|[K|k]opo|[B|b]abakan [T|t]arogong|[J|j]amika|[B|b]abakan [A|a]sih|[S|s]ukaasih|[B|b]abakan|[B|b]abakan [C|c]iparay|[S|s]ukahaji|[M|m]argahayu [U|u]tara|[M|m]argasuka|[C|c]irangrang|[S|s]itusaeur|[K|k]ebon [L|l]ega|[C|c]ibaduyut|[M|m]ekar [W|w]angi|[C|c]ibaduyut [K|k]idul|[C|c]ibaduyut [W|w]etan|[C|c]ijerah|[C|c]ibuntu|[W|w]arung [M|m]uncang|[C|c]aringin|[C|c]igondewah [K|k]aler|[G|g]empol [S|s]ari|[C|c]igondewah [R|r]ahayu|[C|c]igondewah [K|k]idul|[A|a]ntapani [W|w]etan|[A|a]ntapani [T|t]engah|[A|a]ntapani [K|k]ulon|[A|a]ntapani [K|k]idul|[S|s]ukamiskin|[C|c]isaranten [B|b]ina [H|h]arapan|[C|c]isaranten [K|k]ulon|[C|c]isaranten [[F|f]|e]ndah|[P|p]asir [[F|f]|e]ndah|[C|c]igending|[P|p]asir [W|w]angi|[P|p]asir [J|j]ati|[P|p]asanggrahan|[C|c]ipadung|[P|p]asir [B|b]iru|[C|c]isurupan|[P|p]alasari|[C|c]ipamokolan|[M|m]anjahlega|[D|d]erwati|[M|m]ekar [J|j]aya|[S|s]ekejati|[M|m]argasari|[C|c]ijawura|[J|j]atisari|[B|b]atununggal|[W|w]ates|[M|m]engger|[K|k]ujangsari|[C|c]ipadung [K|k]ulon|[C|c]ipadung [W|w]etan|[C|c]ipadung [K|k]idul|[M|m]ekar [M|m]ulya|[C|c]isaranten [W|w]etan|[P|p]akemitan|[S|s]ukamulya|[B|b]abakan [P|p]enghulu|[J|j]ati [H|h]andap|[K|k]arang [P|p]amulang|[S|s]indang [J|j]aya|[P|p]asir [I|i]mpun|[R|r]anca [B|b]olang|[C|c]isaranten [K|k]idul|[C|c]imincrang|[R|r]ancanumpang|[S|s]ukasari|[S|s]ukajadi|[C|c]icendo|[A|a]ndir|[C|c]idadap|[C|c]oblong|[B|b]andung [W|w]etan|[S|s]umur [B|b]andung|[C|c]ibeunying [K|k]aler|[C|c]ibeunying [K|k]idul|[A|a]stanaanyar|[B|b]ojongloa [K|k]aler|[B|b]abakan [C|c]iparay|[B|b]ojongloa [K|k]idul|[B|b]andung [K|k]ulon|[R|r]egol|[L|l]engkong|[B|b]atununggal|[K|k]iaracondong|[A|a]rcamanik|[C|c]ibiru|[A|a]ntapani|[U|u]jung [B|b]erung|[R|r]ancasari|[B|b]uahbatu|[B|b]andung [K|k]idul|[P|p]antileukan|[G|g]edebage|[M|m]andalajati|[C|c]inambo|[I|i]sola|[S|s]ukarasa|[G|g]egerkalong|[S|s]arijadi|[P|p]asteur|[C|c]ipedes|[S|s]ukawarna|[S|s]ukagalih|[S|s]ukabungah|[H|h]usein [S|s]astranegara|[A|a]rjuna|[P|p]ajajaran|[P|p]asirkaliki|[P|p]amoyanan|[S|s]ukaraja|[M|m]aleber|[D|d]ungucariang|[C|c]iroyom|[K|k]ebon [J|j]eruk|[G|g]aruda|[C|c]ampaka|[H|h]egarmanah|[C|c]iumbuleuit|[L|l]edeng|[C|c]ipaganti|[L|l]ebak [G|g]ede|[S|s]adang [S|s]erang|[D|d]ago|[S|s]ekeloa|[L|l]ebak [S|s]iliwangi|[C|c]ihapit|[T|t]aman [S|s]ari|[C|c]itarum|[B|b]raga|[M|m]erdeka|[K|k]ebon [P|p]isang|[B|b]abakan [C|c]iamis|[C|c]ihaurgeulis|[S|s]ukaluyu|[C|c]igadung|[P|p]adasuka|[C|c]ikutra|[C|c]icadas|[S|s]ukamaju|[S|s]ukapada|[P|p]asirlayung|[K|k]ebon [J|j]ayanti|[B|b]abakan [S|s]urabaya|[C|c]icaheum|[B|b]abakan [S|s]ari|[K|k]ebon [K|k]angkung|[G|g]umuruh|[M|m]aleer|[C|c]ibangkong|[K|k]acapiring|[K|k]ebon [W|w]aru|[K|k]ebon [G|g]edang|[S|s]amoja|[B|b]inong|[C|c]ijagra|[L|l]ingkar [S|s]elatan|[B|b]urangrang|[P|p]aledang|[T|t]urangga|[M|m]alabar|[C|c]ikawao|[C|c]igereleng)","(Jalan [^\\s]+)","(Jl[ |.|n]?[ |.|n][^\\s]+)","(di [^\\s]+)"};
    	int size = arrOfPattern.length;
    	int i = 0;
    	while(i<size){
    		Pattern p = Pattern.compile(arrOfPattern[i]); // Untuk mendapatkan daerah
    		Matcher m = p.matcher(masukan);
    		if (m.find())
    		{
    			/* tambah jumlah kategori, masukin ke array, masukin ke array lokasi */
    			//System.out.println(m.group(1));
    			out = m.group(1);
    			i = size; // hilangkan bila ingin mengecek semua pattern
    		}
    		i++;
    	}
    	
    	return out;
    }
}