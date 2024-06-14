package com.example.quiz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.quiz.constants.OptionType;
import com.example.quiz.service.itfs.QuizService;
import com.example.quiz.vo.BasicRes;
import com.example.quiz.vo.CreateOrUpdateReq;
import com.example.quiz.vo.Question;

//@SpringBootTest
public class QuizServiceTests {

	@Autowired
	private QuizService quizService;

	@Test
	public void createTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "���d�\?", "�Q����;���ޱ�;�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "����", "1���\;2���\;3���\;4���\�Q����;���ޱ�;�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "����?", "�ަת���;���A����;�z�����a��(��);��X����", //
				OptionType.SINGLE_CHOICE.getType(), true));
		CreateOrUpdateReq req = new CreateOrUpdateReq(0, "���\�Yԣ?", "���\�Yԣ?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
		// �R�����ո�� TODO

	}

	@Test
	public void createNameErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "���d�\?", "�Q����;���ޱ�;�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "����", "1���\;2���\;3���\;4���\�Q����;���ޱ�;�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "����?", "�ަת���;���A����;�z�����a��(��);��X����", //
				OptionType.SINGLE_CHOICE.getType(), true));
		CreateOrUpdateReq req = new CreateOrUpdateReq(0, "", "���\�Yԣ?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");

	}

	@Test
	public void createStartDateErrorTest() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "���d�\?", "�Q����;���ޱ�;�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(2, "����", "1���\;2���\;3���\;4���\�Q����;���ޱ�;�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		questionList.add(new Question(3, "����?", "�ަת���;���A����;�z�����a��(��);��X����", //
				OptionType.SINGLE_CHOICE.getType(), true));
		// ���ѬO 2024/5/30�A�ҥH�}�l�������O��ѩάO���e
		CreateOrUpdateReq req = new CreateOrUpdateReq(0, "���\�Yԣ?", "���\�Yԣ?", LocalDate.of(2024, 5, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");

	}

	@Test
	public void createTest1() {
		List<Question> questionList = new ArrayList<>();
		questionList.add(new Question(1, "���d�\?", "�Q����;���ޱ�;�N���L", //
				OptionType.SINGLE_CHOICE.getType(), true));
		// ���� name error
		CreateOrUpdateReq req = new CreateOrUpdateReq(0, "", "���\�Yԣ?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		BasicRes res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param name error!!"), "create test false!!");
		// ���� start date error: ���]���ѬO 2024/5/30�A�ҥH�}�l�������O��ѩάO���e
		req = new CreateOrUpdateReq(0, "���\�Yԣ?", "���\�Yԣ?", LocalDate.of(2024, 5, 30), //
				LocalDate.of(2024, 6, 1), questionList, true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param start date error!!"), "create test false!!");
		// ���� end date error: ������������}�l�����
		req = new CreateOrUpdateReq(0, "���\�Yԣ?", "���\�Yԣ?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 5, 30), questionList, true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getMessage().equalsIgnoreCase("Param end date error!!"), "create test false!!");
		// �Ѿl���޿�����P�_������A�̫�~�|�O���զ��\������
		req = new CreateOrUpdateReq(0, "���\�Yԣ?", "���\�Yԣ?", LocalDate.of(2024, 6, 1), //
				LocalDate.of(2024, 6, 1), questionList, true);
		res = quizService.createOrUpdate(req);
		Assert.isTrue(res.getStatusCode() == 200, "create test false!!");
	}

	@Test
	public void sumTest() {
		List<String> list = List.of("����", "���", "�Q�s", "����", "�M��", "����", "����", "����");
//		resultList = input_string.split(';');
		String target = "����";
		int sum = 1;
		List<String> indexList = new ArrayList<>();
		// ��k1
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) == list.get(j)) {
					indexList.add(list.get(i));
					sum = sum + 1;
				}
			}

		}
		System.out.println(indexList);
		System.out.println(sum);
	}

	@Test
	public void test9() {
		List<String> list = List.of("����", "���", "�Q�s", "����", "�M��", "����", "����", "����");
		String str = "����L�Q";
		// �ΪŦr��h���A�|���ΨC�Ӧr: [��, ��, �L, �Q]
		String[] newStr = str.split("");
		// �ΪŦr��h���A�|���ΨC�Ӧr: [��, �L�Q]
		String[] newStr2 = str.split("��");
		for (String item : list) {
			System.out.println(item);
		}
		// newStr2 = ��_��_�L_�Q
		// join: �Ω�N�r�ꪺ�}�C/���X�ꦨ�s�r��
//		String newStr3 = String.join("_", newStr);
//		System.out.println(newStr3);
	}

	@Test
	public void hw3() {
		List<String> list = List.of("A", "B", "C", "D", "E");
		String str = "AABCBDCDACBDA";

		Map<String, Integer> map = new HashMap<>();
		for (String item : list) {
			String newStr = str.replace(item, "");
			System.out.println("str = " + str);
			System.out.println("newStr = " + newStr);
			int count = str.length() - newStr.length();
			map.put(item, count);

		}
		System.out.println(map);

	}
}
